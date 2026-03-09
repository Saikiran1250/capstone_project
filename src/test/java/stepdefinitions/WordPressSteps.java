package stepdefinitions;

import base.BaseClass;
import pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class WordPressSteps extends BaseClass {

    HomePage home;
    DownloadPage download;
    PhotoDirectoryPage photo;

    @Given("User launches the WordPress website")
    public void launch_site() {
        setup();
        home = new HomePage(driver);
    }

    @Then("User verifies the page title")
    public void verify_title() {
        Assert.assertEquals(driver.getTitle(), 
        "Blog Tool, Publishing Platform, and CMS – WordPress.org");
    }

    @When("User mouse over on Download & Extend and click Get WordPress")
    public void mouse_over() {
        home.clickGetWordPress();
        download = new DownloadPage(driver);
    }

    @Then("User verifies {string} text")
    public void verify_text(String expected) {

        Assert.assertEquals(download.verifyText(), expected);

        driver.get("https://wordpress.org/");
    }

    @When("User clicks on Community and selects Photo Directory")
    public void click_photo_directory() {
        home = new HomePage(driver);  // recreate object
        home.clickCommunityPhoto();
        photo = new PhotoDirectoryPage(driver);
    }

    @Then("User searches for a photo and verifies pictures are displayed")
    public void search_photo() {
        photo.searchPhoto("mountains");
        Assert.assertTrue(photo.verifyImagesDisplayed());
        tearDown();
    }
}
