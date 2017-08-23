package com.statravel.autoqa.commons;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.statravel.autoqa.config.SeleniumProperties;
import com.statravel.autoqa.domain.browser.Browser;
import com.statravel.autoqa.domain.browser.ChromeBrowser;
import com.statravel.autoqa.domain.browser.IEBrowser;
import com.statravel.autoqa.domain.browser.FireFoxBrowser;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
@Scope("prototype")
public final class WebDriverFactory {

    private static final Logger LOGGER = Logger.getLogger(WebDriverFactory.class);

    private static final String SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE = "Not able to retrieve the web driver session";

    private static WebDriver webDriver;

    /**
     * 
     */
    private WebDriverFactory() {

    }

    /**
     * 
     * @return WebDriver instance
     */
    public static WebDriver initWebDriver() {

        String browser = System.getProperty("browser");

        URL seleniumHostURL = null;

        try {

            seleniumHostURL = new URL(SeleniumProperties.getHost());

        } catch (MalformedURLException mue) {

            LOGGER.error("Could not connect to Remote Webdrive", mue);

        }

        if (webDriver == null || !isSessionActive()) {

            if (browser.equalsIgnoreCase("chrome")) {


                Browser chrome = new ChromeBrowser();

                webDriver = new RemoteWebDriver(seleniumHostURL, chrome.getCapabilities());


            } else if (browser.equalsIgnoreCase("firefox")) {

                Browser firefox = new FireFoxBrowser();

                webDriver = new RemoteWebDriver(seleniumHostURL, firefox.getCapabilities());

            } else if (browser.equalsIgnoreCase("IE")) {

                Browser ie = new IEBrowser();

                webDriver = new RemoteWebDriver(seleniumHostURL, ie.getCapabilities());

            }
        }

        webDriver.get(SeleniumProperties.getAppURL());

        webDriver.manage()
                 .window()
                 .maximize();

        return webDriver;

    }

    /**
     * @return the webDriver
     */
    public static WebDriver getWebDriver() {

        return webDriver;
    }

    /**
     * Checks if the session is active.
     * 
     * @return true if the session is active, false otherwise
     */
    private static boolean isSessionActive() {

        try {
            return webDriver.findElements(By.tagName("body"))
                            .size() > 0;

        } catch (Exception ex) {

            LOGGER.error(SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE, ex);
            return false;
        }

    }

    /**
     * Shuts down the WebDriver.
     * @throws InterruptedException 
     */
    public static void quitWebDriver() {

        if (webDriver != null) {
     
            webDriver.quit();

        }
    }

}
