package com.xosmig.seleniumhw;

import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.Assert.*;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class YouTrackTest {

    private static WebDriver driver;

    @BeforeClass
    public static void driverInit() {
        URL driverUnix = Thread.currentThread().getContextClassLoader().getResource("geckodriver");
        URL driverWindows = Thread.currentThread().getContextClassLoader().getResource("geckodriver.exe");
        URL driverUrl = driverUnix != null ? driverUnix : driverWindows;
        assertNotNull(driverUrl);

        System.setProperty("webdriver.gecko.driver", driverUrl.getPath());
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void driverDeinit() {
        driver.close();
    }

    @Test
    public void testFoo() {
        assertEquals(1, 1);
    }
}
