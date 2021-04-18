package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    private boolean isVisible = false;

    public boolean elementIsClickable(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable((element)));
            isVisible = true;
        }catch (Exception notClickable){
            isVisible = false;
        }
        return isVisible;
    }

    public boolean elementIsVisible(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOf((element)));
            isVisible = true;

        } catch (Exception notVisible) {
            isVisible = false;

        }
        return isVisible;
    }
    public void elementContainText(WebDriver driver, WebElement element, String text, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
