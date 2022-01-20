package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    WebDriver driver;
    HomePage homePage;
    ContactBBCPage contactBBCPage;
    CoronavirusPage coronavirusPage;
    NewsPage newsPage;
    ShareNewsPage shareNewsPage;
    PageFactoryManager pageFactoryManager;
    SearchResultPage searchResultPage;

    private final static long TIME_TO_WAIT= 30;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @Given("User open BBC page")
    public void userOpenBBCPage() {
        homePage=pageFactoryManager.getHomePage();
        homePage.openHomePage();
    }

    @And("User clicks on news")
    public void userClicksOnNews() {
        homePage.clickNews();
    }

    @And("User clicks on coronavirus")
    public void userClicksOnCoronavirus() {
        newsPage=pageFactoryManager.getNewsPage();
        newsPage.clickCoronavirus();
    }

    @And("User clicks contact BBC")
    public void userClicksContactBBC() {
        coronavirusPage=pageFactoryManager.getCoronavirusPage();
        coronavirusPage.clickContactBBC();
    }

    @And("User clicks send story")
    public void userClicksSendStory() {
        contactBBCPage=pageFactoryManager.getContactBBCPage();
        contactBBCPage.clickSendUsAStory();
    }

    @And("User closes popup")
    public void userClosesPopup() {
        shareNewsPage=pageFactoryManager.getShareNewsPage();
        shareNewsPage.waitVisibilityOfElement(TIME_TO_WAIT,shareNewsPage.getButtonOfClosePopup());
        shareNewsPage.clickButtonOfPopup();

    }

    @And("blabla")
    public void blabla() {

        homePage=pageFactoryManager.getHomePage();
        homePage.openHomePage1();
    }

    @When("A user fills the form with empty or invalid required fields and clicks or doesn't click on accept")
    public void aUserFillsTheFormWithEmptyOrInvalidRequiredFields(Map<String, String> map) {
        shareNewsPage=pageFactoryManager.getShareNewsPage();
        shareNewsPage.waitVisibilityOfElement(30,shareNewsPage.getButtonOfClosePopup());
        shareNewsPage.clickButtonOfPopup();

        shareNewsPage=pageFactoryManager.getShareNewsPage();
        shareNewsPage.fillFormsInputs(map);

    }
    @And("User clicks on submit button")
    public void userClicksOnSubmitButton() {
        shareNewsPage.clickButtonOfSubmit();
    }

    @Then("User checks that submit is still enabled")
    public void userChecksThatSubmitIsStillEnabled() {
        Assert.assertTrue(shareNewsPage.isButtonOfSubmitDisplayed());
    }


//    @And("blabla{int}")
//    public void blabla(int arg0) {
//        homePage=pageFactoryManager.getHomePage();
//        homePage.openHomePage1();
//    }

    @And("User opens BBC home page")
    public void userOpensBBCHomePage() {
        homePage=pageFactoryManager.getHomePage();
        homePage.openHomePage();
    }

    @Then("User checks that secondary news has on of this titles")
    public void userChecksThatSecondaryNewsHasOnOfThisTitles(List<String> expectedSecondaryNewsTitles) {
        newsPage=pageFactoryManager.getNewsPage();
        Assert.assertTrue(newsPage.isTitlesOfSecondaryArticlesCorrect(newsPage.getListOfNameOfSecondaryArticle(),expectedSecondaryNewsTitles));
    }

    @Then("User checks that name of main article is {string}")
    public void userChecksThatNameOfMainArticleIsName(String expectedTitleOfMainArticle) {
        newsPage=pageFactoryManager.getNewsPage();
        Assert.assertEquals(newsPage.getTitleOfMainArticle(),expectedTitleOfMainArticle);
    }

    @And("User makes search by name of category of main article")
    public void userMakesSearchByNameOfCategoryOfMainArticle() {
        newsPage=pageFactoryManager.getNewsPage();
        newsPage.searchByNameOfCategoryOfMainArticle();
    }

    @Then("User checks that title is {string}")
    public void userChecksThatTitleIs(String title) {
        searchResultPage=pageFactoryManager.getSearchResultPage();
        Assert.assertEquals(searchResultPage.getNameOfFirstArticle(),title);
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
