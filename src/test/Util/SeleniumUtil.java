package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtil {
    private boolean isPresent = false;

    WaitUtil waitUtil = new WaitUtil();

    public WebElement findElementByDataRef(WebDriver driver, String element) {
        WebElement webElement = null;
        try {
            webElement = driver.findElement(By.xpath("//*[@data-ref='" + element + "']"));
        } catch (Exception notFound) {

        }
        return webElement;
    }

    public WebElement findElementByDataId(WebDriver driver, String element) {
        WebElement webElement = null;
        try {
            webElement = driver.findElement(By.xpath("//*[@data-id='" + element + "']"));
        } catch (Exception notFound) {

        }
        return webElement;
    }

    public void selectDropdownListOption(WebDriver driver, List<WebElement> element, String option) {
        switch (option) {
            case "Mr":
                waitUtil.elementIsClickable(driver, element.get(0), 10);
                element.get(0).click();
                break;
            case "Mrs":
                waitUtil.elementIsClickable(driver, element.get(1), 10);
                element.get(1).click();
                break;
            case "Ms":
                waitUtil.elementIsClickable(driver, element.get(2), 10);
                element.get(2).click();
                break;
        }
    }

}

