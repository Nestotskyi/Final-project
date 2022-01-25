package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ShareNewsPage extends BasePage {

    public ShareNewsPage(WebDriver driver) {
        super(driver);
    }

    private String stringForXpath="//input[@aria-label='%s']";

            public void fillFormsInputs (Map < String, String > dataForForm){
                for (Map.Entry<String, String> entry : dataForForm.entrySet()) {
                    if (entry.getKey().equals("story")) {
                            fieldForMessage.sendKeys(entry.getValue() != null ? entry.getValue() : "");
                    } else {
                        WebElement field = driver.findElement(By.xpath(format(stringForXpath, entry.getKey())));
                        field.sendKeys(entry.getValue() != null ? entry.getValue() : "");
                    }
                }
            }
            public void accept(String accept){
                if (accept.equals("yes")) {
                    buttonOfAccept.click();
                }
            }
    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement fieldForEmail;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement fieldForName;
    @FindBy(xpath = "//textarea[@placeholder='Tell us your story. ']")
    private WebElement fieldForMessage;
    @FindBy(xpath = "//p[text()='I accept the ']/../../../input")
    private WebElement buttonOfAccept;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement buttonOfSubmit;
    @FindBy(xpath = "//div[text()='Email address is invalid']")
    private WebElement reportAboutWrongEmail;
    @FindBy(xpath = "//div[@class='input-threeup-leading ']//input")
    private WebElement reportAboutMissName;
    @FindBy(xpath = "//div[contains(@class,'input-container')]//div[@class='input-error-message']")
    private WebElement reportAboutEmptyMassage;

    public boolean isButtonOfSubmitDisplayed(){return buttonOfSubmit.isDisplayed();}
    public void clickButtonOfSubmit(){
        buttonOfSubmit.click();
    }


}
