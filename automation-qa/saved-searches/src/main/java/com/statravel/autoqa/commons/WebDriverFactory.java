package com.statravel.autoqa.commons;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.statravel.autoqa.config.SeleniumProperties;
import com.statravel.autoqa.domain.browser.Browser;
import com.statravel.autoqa.domain.browser.ChromeBrowser;
import com.statravel.autoqa.domain.browser.FirefoxBrowser;
import com.statravel.autoqa.domain.browser.InternetExplorerBrowser;
import com.statravel.autoqa.domain.browser.SafariBrowser;
import com.statravel.autoqa.domain.enumeration.Browsers;

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

    private static final String BROWSER = "browser";

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

        String browser = System.getProperty(BROWSER);

        if (webDriver == null || !isSessionActive()) {

            Browser browserClass = null;

            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {

                browserClass = new ChromeBrowser();

                System.out.println(browser);

            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {

                browserClass = new FirefoxBrowser();

                System.out.println(browser);

            } else if (browser.equalsIgnoreCase(Browsers.IE.name())) {

                browserClass = new InternetExplorerBrowser();

                System.out.println(browser);

            } else if (browser.equalsIgnoreCase(Browsers.SAFARI.name())) {

                browserClass = new SafariBrowser();

                System.out.println(browser);

            }

            try {
            	
            	browserClass.getCapabilities().setCapability("javascriptEnabled", true);   

                webDriver = new RemoteWebDriver(new URL(SeleniumProperties.getHost()), browserClass.getCapabilities());

            } catch (MalformedURLException mue) {

                LOGGER.error(mue);

            }

            webDriver.get(SeleniumProperties.getAppURL());

        }

        webDriver.manage().window().maximize();

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
            return webDriver.findElements(By.tagName("body")).size() > 0;

        } catch (Exception ex) {

            LOGGER.error(SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE, ex);
            return false;
        }

    }

    /**
     * Shuts down the WebDriver.
     */
    public static void quitWebDriver() {

        if (webDriver != null) {

            //webDriver.quit();
        }
    }

}
