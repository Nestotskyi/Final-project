package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//header//li[@class='orb-nav-newsdotcom']/a[text()='News']")
    private WebElement news;

    public void clickNews(){news.click();}
    public void openHomePage(){driver.get("https://www.bbc.com/");}
    public void openHomePage1(){driver.get("https://www.bbc.com/news/10725415");}
}
