package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By getWordPress = By.xpath("//a[normalize-space()='Get WordPress']");
    By communityButton = By.xpath("//button[normalize-space()='Community']");
    By photoDirectory = By.xpath("//a[contains(@href,'photos')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔥 THIS METHOD MUST EXIST
    public void clickGetWordPress() {

        By getWordPress = By.cssSelector("a[href='/download/']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(getWordPress));
        wait.until(ExpectedConditions.elementToBeClickable(getWordPress)).click();
    }

    public void clickCommunityPhoto() {
        wait.until(ExpectedConditions.elementToBeClickable(communityButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(photoDirectory)).click();
    }
}