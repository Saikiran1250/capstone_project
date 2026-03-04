package pages;

import org.openqa.selenium.*;

public class DownloadPage {

    WebDriver driver;

    By middleText = By.xpath("//h1[contains(text(),'Get WordPress')]");

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyText() {
        return driver.findElement(middleText).getText();
    }
}