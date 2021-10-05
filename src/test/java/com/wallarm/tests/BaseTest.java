package com.wallarm.tests;

import com.codeborne.selenide.Selenide;
import com.wallarm.configuration.WebDriverConfig;
import com.wallarm.rules.CustomTestExecutionListener;
import com.wallarm.utils.DriverHelper;
import com.wallarm.utils.Logger;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import static java.lang.String.format;

public abstract class BaseTest {

    protected Logger logger = Logger.getInstance();

    @BeforeAll
    public static void config() {
        DriverHelper.configureDriver();
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        Selenide.open();
        logger.info(format("Test %s started", testInfo.getDisplayName()));
    }

    @AfterEach()
    public void tearDown(TestInfo testInfo) {
        logger.info(format("Test %s is finished", testInfo.getDisplayName()));
    }


}
