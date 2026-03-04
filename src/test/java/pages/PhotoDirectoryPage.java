package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class PhotoDirectoryPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.xpath("//*[@id=\"wp-block-search__input-8\"]");
    By images = By.cssSelector("img");

    public PhotoDirectoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchPhoto(String name) {

        wait.until(ExpectedConditions.urlContains("photos"));

        List<WebElement> inputs = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//input[@type='search' and contains(@class,'wp-block-search__input')]")));

        WebElement visibleSearch = null;

        for (WebElement input : inputs) {
            if (input.isDisplayed()) {
                visibleSearch = input;
                break;
            }
        }

        if (visibleSearch == null) {
            throw new RuntimeException("Visible search input not found");
        }

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", visibleSearch);

        visibleSearch.click();
        visibleSearch.clear();
        visibleSearch.sendKeys(name);
        visibleSearch.sendKeys(Keys.ENTER);
    }

    public boolean verifyImagesDisplayed() {

        wait.until(ExpectedConditions.presenceOfElementLocated(images));

        List<WebElement> pics = driver.findElements(images);

        return pics.size() > 0;
    }
}