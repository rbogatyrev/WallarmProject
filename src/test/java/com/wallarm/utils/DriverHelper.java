package com.wallarm.utils;

import com.codeborne.selenide.Configuration;
import com.wallarm.configuration.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class DriverHelper {

   private static WebDriverConfig driverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    public static void switchToBlankTab(){
        executeJavaScript("window.open('about:blank', '_blank')");
        switchTo().window(1);
    }

    public static void configureDriver(){
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";

        if (driverConfig.isRemote()){
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("enableVNC", true);
            caps.setCapability("enableVideo", true);
            caps.setCapability("browserName", "chrome");
            caps.setCapability("version", driverConfig.chromeVersion());
            Configuration.remote = driverConfig.remoteUrl();
            Configuration.browserCapabilities = caps;
        }

    }

    public static URL getVideoUrl(String sessionId){
        String videoUrl = driverConfig.videoUrlPart() + sessionId + ".mp4";
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            Logger.getInstance().warn(format("[ALLURE VIDEO ATTACHMENT ERROR] Wrong test video url, {}", videoUrl));
            e.printStackTrace();
        }
        return null;
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

}
