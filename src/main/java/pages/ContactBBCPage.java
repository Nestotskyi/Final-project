package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactBBCPage extends BasePage{
    public ContactBBCPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='send us a story']")
    private WebElement sendUsAStory;

    public void clickSendUsAStory(){
        sendUsAStory.click();
    }
}
