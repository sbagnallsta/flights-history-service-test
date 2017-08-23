package com.statravel.autoqa.commons;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class WebDriverCommons {

    private static final Logger LOGGER = Logger.getLogger(WebDriverCommons.class);

    private static final int WEBDRIVER_PAUSE_TIME = 30;

    public static final int TIMEOUT_FOR_HIGHLIGHT_ELEMENT = 100;

    public static final String FAILED_TO_DISPLAY_ELEMENT_MESSAGE = "Failed to display element";

    public static final String FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE = "Failed to enter given value to given element";

    public static final String FAILED_TO_CLICK_ON_GIVEN_ELEMENT_MESSAGE = "Failed to click on given element";

    public static final String FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE = "Failed to highlight element for given time";

    public static final int SIXTY_UNITS = 60;

    public static final int TEN_UNITS = 10;

    public static final int SIZE_FIVE = 5;

    public static final int TIME_OUT_IN_SECONDS = 1000;

    /**
     * Pauses the WebDriver process for a specific time.
     * 
     * @param element
     *            element to wait for
     */
    public void waitForElementToBeVisible(final WebElement element) {

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), WEBDRIVER_PAUSE_TIME);

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Create select.
     * 
     * @param element
     *            element to manage
     * @return select
     */
    public Select createSelect(final WebElement element) {

        return new Select(element);

    }

    /**
     * @param url
     *            url to navigate to
     * 
     */
    public void goToUrl(final String url) {

        WebDriverFactory.getWebDriver()
                        .get(url);

    }

    /**
     * @param driver
     */
    public void waitForLoad() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState")
                                                                                                        .equals("complete"));
    }

    /**
     * @param driver
     */
    public void waitForAjaxToFinish() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        new WebDriverWait(driver, 30).until(
                (ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return((window.jQuery != null) && (jQuery.active == 0))")
                                                                            .equals(true));
    }

    /**
     * @param time
     *            how long to sleep for
     * 
     * @throws InterruptedException
     *             throws this exception
     */
    public void sleep(final int time) throws InterruptedException {
        Thread.sleep(time);

    }

    /**
     * 
     * @param url
     *            that you want to check against
     * @return true if urls match
     */
    public boolean checkCurrentUrl(final String url) {
        // WebDriver driver = WebDriverFactory.getWebDriver();
        return WebDriverFactory.getWebDriver()
                               .getCurrentUrl()
                               .equals(url);
    }

    /**
     * Highlight element with yellow colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementYellowColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid yellow;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Highlight element with red colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementWithRedColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Highlight element with blue colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementWithBlueColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid blue;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Pauses the WebDriver process for a specific time.
     * 
     */

    public void waitForPageLoaded() {

        WebDriver driver = WebDriverFactory.getWebDriver();
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                                                    .equals("complete");
            }
        };

        Wait<WebDriver> wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        wait.until(expectation);

    }

    /**
     * Waits for element to be clickable.
     * 
     * @param element
     *            element to wait for
     * 
     */
    public void waitForElementToBeClickable(final WebElement element) {

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), WEBDRIVER_PAUSE_TIME);

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    /**
     * Scrolls the driver to the element given.
     * 
     * @param element
     *            element to scroll to
     */
    public void scrollTo(final WebElement element) {

        waitForElementToBeVisible(element);

        JavascriptExecutor jse = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        jse.executeScript("arguments[0].scrollIntoView();", element);

    }

    /**
     * Scroll to bottom of the page.
     */
    public void scrollToBottom() {

        ((JavascriptExecutor) WebDriverFactory.getWebDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    /**
     * Selects and item from a drop down element.
     * 
     * @param element
     *            element to manage
     * @param text
     *            text
     */
    public void selectFromDropdown(final WebElement element, final String text) {
        scrollTo(element);

        getHighlightElementYellowColour(element);

        Select select = new Select(element);

        select.selectByVisibleText(text);
    }

    /**
     * Selects and item from a drop down element by index.
     * 
     * @param element
     *            element to manage
     * @param index
     *            index
     */
    public void selectValueFromDropdownByIndex(final WebElement element, final int index) {
        scrollTo(element);

        getHighlightElementWithRedColour(element);

        Select select = new Select(element);

        select.selectByIndex(index);
    }

    /**
     * Get alert pop up.
     * 
     * @return Alert pop up
     */
    public Alert getAlertPopUp() {

        Alert alert = WebDriverFactory.getWebDriver()
                                      .switchTo()
                                      .alert();

        return alert;

    }

    /**
     * to check is element displayed or not by by.
     * 
     * @param by
     *            by
     * @return true if element display else false
     */
    public boolean isDisplayed(final By by) {

        try {

            return WebDriverFactory.getWebDriver()
                                   .findElement(by)
                                   .isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, by), nsee);
            return false;

        }
    }

    /**
     * to check is element displayed or not by element.
     * 
     * @param element
     *            element
     * @return true if element display else false
     */
    public boolean isDisplayed(final WebElement element) {
        scrollTo(element);

        try {

            getHighlightElementWithRedColour(element);
            return element.isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, element), nsee);
            return false;
        }
    }

    /**
     * clear value from given element.
     * 
     * @param element
     *            element
     */
    public void clear(final WebElement element) {
        scrollTo(element);
        getHighlightElementYellowColour(element);
        element.clear();
    }

    /**
     * click on given element.
     * 
     * @param element
     *            element
     */
    public void click(final WebElement element) {

        try {

            scrollTo(element);
            getHighlightElementWithBlueColour(element);
            element.click();

        } catch (Exception e) {
            LOGGER.info(MessageFormat.format(FAILED_TO_CLICK_ON_GIVEN_ELEMENT_MESSAGE, element), e);
        }
    }

    /**
     * enter value to given element.
     * 
     * @param element
     *            element
     * @param value
     *            value
     */
    public void sendKeys(final WebElement element, final String value) {

        try {

            scrollTo(element);
            clear(element);
            element.sendKeys(value);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);
        }
    }

    /**
     * enter value to given element with out deleting from that element.
     * 
     * @param element
     *            element
     * 
     * @param value
     *            value
     */
    public void sendKeysWithOutClear(final WebElement element, final String value) {

        try {

            scrollTo(element);
            getHighlightElementYellowColour(element);
            element.sendKeys(value);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);

        }
    }

    /**
     * enter value to given element.
     * 
     * @param element
     *            element
     * @param keys
     *            keys
     */
    public void sendKeys(final WebElement element, final Keys keys) {

        try {

            scrollTo(element);
            clear(element);
            element.sendKeys(keys);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);

        }

    }

    /**
     * 
     * @param element
     *            element
     * @return text as string from given element otherwise null if no text found;
     */
    public String getText(final WebElement element) {

        try {
            scrollTo(element);
            getHighlightElementYellowColour(element);
            return element.getText();
        } catch (NoSuchElementException nsee) {
            Assert.assertTrue("Fail to get text value from : " + element + " on page : " + nsee.getMessage(), false);

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());

        }
        return null;
    }

    /**
     * Switch to given frame number.
     * 
     * @param frameNo
     *            frameNo
     * @throws InterruptedException
     *             InterruptedException
     */
    public void swithToFrame(final int frameNo) throws InterruptedException {
        Thread.sleep(3000);

        WebDriverFactory.getWebDriver()
                        .switchTo()
                        .frame(frameNo);

    }

    /**
     * enter given url.
     * 
     * @param url
     *            url
     */
    public void enterUrl(final String url) {

        WebDriverFactory.getWebDriver()
                        .get(url);

    }

    public void hoverOverAndClick(final WebElement firstElement, final WebElement secondElement) {
        Actions action = new Actions(WebDriverFactory.getWebDriver());
        action.moveToElement(firstElement)
              .perform();
        action.moveToElement(secondElement)
              .perform();
        action.click();
        action.perform();
    }

    public void hoverOver(final WebElement firstElement) {
        Actions action = new Actions(WebDriverFactory.getWebDriver());
        action.moveToElement(firstElement)
              .perform();

    }
}
