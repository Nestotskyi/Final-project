package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage{
    public NewsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//ul[contains(@class,'wide')]//a[@class='nw-o-link']/span[text()='Coronavirus']")
    private WebElement coronavirus;
    @FindBy(xpath = "//div[contains(@class,'block@m')]//h3[contains(@class,'-paragon-bold')]")
    private WebElement mainArticle;
    @FindBy(xpath = "//div[@aria-label='Top Stories']//div[contains(@class,'mt@m')]//a[contains(@class,' gs-o-faux-block-link')]")
    private List<WebElement> listOfNameOfSecondaryArticle;
    @FindBy(xpath = "//div[contains(@class,'nline-block@m')]//a//span")
    private WebElement nameOfCategoryOfMainArticle;
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement fieldForSearch;

    public void searchByNameOfCategoryOfMainArticle(){fieldForSearch.sendKeys(getNameOfCategoryOfMainArticle()+"\n");}
    public String getNameOfCategoryOfMainArticle(){return nameOfCategoryOfMainArticle.getText();}
    public List<WebElement> getListOfNameOfSecondaryArticle(){return listOfNameOfSecondaryArticle;}
    public String getTitleOfMainArticle(){return mainArticle.getText();}
    public void clickCoronavirus(){coronavirus.click();}

    public boolean isTitlesOfSecondaryArticlesCorrect(List<WebElement> webElements, List<String> expectedTitles){
        int count=0;
        System.out.println(webElements.size());
        for(int i=0;i<webElements.size();i++){
            System.out.println(webElements.get(i).getText());
            if(expectedTitles.contains(webElements.get(i).getText())){
                count++;
            }
        }
        return count==webElements.size();
    }
}
