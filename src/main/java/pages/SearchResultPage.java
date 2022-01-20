package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@aria-hidden='false']")
    private List<WebElement> listOfNameOfArticles;

    public String getNameOfFirstArticle(){
        return listOfNameOfArticles.get(0).getText();
    }
}
