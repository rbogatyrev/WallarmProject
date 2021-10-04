package com.wallarm.rules;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.wallarm.configuration.WebDriverConfig;
import com.wallarm.utils.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;

import static com.google.common.io.Files.toByteArray;
import static java.lang.String.format;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class CustomTestExecutionListener implements TestExecutionListener {

    private WebDriverConfig driverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    /**
     * Make screenshot and attach to Allure
     *
     * @return Screenshot file
     */

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] makeScreenshot(TestIdentifier testIdentifier) {

        DateFormat date = new DateFormat();
        File file = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        String path = "target/generated-test-sources/" + testIdentifier.getClass().getName().replace("Tests", "") + "_"
                + testIdentifier.getDisplayName() + date.get(Calendar.DAY_OF_MONTH) + date.get(Calendar.MONTH) + date.get(Calendar.HOUR) + date.get(Calendar.MINUTE) + "/" + file.getName();
        File copiedFile = new File(path);
        try {
            FileUtils.copyFile(file, new File(path));
            Logger.getInstance().info(format("Screenshot path is: %s", copiedFile.getAbsolutePath()));
            return java.nio.file.Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Record console-log and attach to Allure
     *
     * @param testIdentifier - test execution context
     * @return file as byteArray
     */
    @Attachment(value = "Console log", type = "text/plain")
    public static byte[] saveConsoleLog(TestIdentifier testIdentifier) {
        DateFormat date = new DateFormat();
        String logs = String.join("\n", Selenide.getWebDriverLogs(BROWSER));
        try {
            File file = new File("target/generated-test-sources/" + testIdentifier.getClass().getName().replace("Tests", "") + "_" + testIdentifier.getDisplayName() + date.get(Calendar.DAY_OF_MONTH) + date.get(Calendar.MONTH) + date.get(Calendar.HOUR) + date.get(Calendar.MINUTE) + "/consoleLogs.txt");
            FileUtils.writeStringToFile(file, logs, Charset.forName("UTF-8"));
            byte[] consoleLog = toByteArray(file);
            return consoleLog;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addVideo(String sessionId) {
        URL videoUrl = DriverHelper.getVideoUrl(sessionId);
        if (videoUrl != null) {
            InputStream videoInputStream = null;
            SimpleWait.waitSec(1);

            for (int i = 0; i < 10; i++) {
                try {
                    videoInputStream = videoUrl.openStream();
                    break;
                } catch (FileNotFoundException e) {
                    SimpleWait.waitSec(1000);
                } catch (IOException e) {
                    Logger.getInstance().warn(format("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", videoUrl));
                    e.printStackTrace();
                }
            }
            Allure.addAttachment("Video", "video/mp4", videoInputStream, "mp4");
        }
    }


    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        String sessionId = DriverHelper.getSessionId();
        if (testExecutionResult.getThrowable().isPresent()) {
            makeScreenshot(testIdentifier);
            saveConsoleLog(testIdentifier);
        }
          Selenide.closeWebDriver();
        if (driverConfig.isRemote()){
            CustomTestExecutionListener.addVideo(sessionId);
        }
    }

}
