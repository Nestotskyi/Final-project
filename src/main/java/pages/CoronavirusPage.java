package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage{
    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Contact BBC News']")
    private WebElement contactBBC;

    public void clickContactBBC(){
        contactBBC.click();
    }
}
