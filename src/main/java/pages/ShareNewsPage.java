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

            public void fillFormsInputs(Map<String, String> dataForForm) {
                for (Map.Entry<String, String> entry : dataForForm.entrySet()) {

                    if (entry.getKey().equals("story")) {
                        if (entry.getValue() != null) {
                            fieldForMessage.sendKeys(entry.getValue());
                        }
                    } else
                        if (entry.getKey().equals("accept")) {
                            if (entry.getValue().equals("yes")) {
                                buttonOfAccept.click();
                            }
                        } else {
                            WebElement field = driver.findElement(By.xpath(format(stringForXpath, entry.getKey())));
                            field.sendKeys(entry.getValue() != null ? entry.getValue() : "");
                        }
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
    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement buttonOfClosePopup;
    @FindBy(xpath = "//div[text()=' must be accepted']")
    private WebElement reportAboutMissAccepted;
    @FindBy(xpath = "//div[@class='input-threeup-leading ']//input")
    private WebElement reportAboutMissName;

    public boolean isButtonOfSubmitDisplayed(){return buttonOfSubmit.isDisplayed();}
    public WebElement getReportAboutMissName(){
        return reportAboutMissName;
    }
    public WebElement getReportAboutMissAccepted(){
        return reportAboutMissAccepted;
    }
    public void inputForEmail(String email){
        fieldForEmail.sendKeys(email);
    }
    public void clickButtonOfSubmit(){
        buttonOfSubmit.click();
    }
    public void clickButtonOfAccept(){
        buttonOfAccept.click();
    }
    public void inputMessage(String message){
        fieldForMessage.sendKeys(message);
    }
    public void inputName(String name){
        fieldForName.sendKeys(name);
    }
    public WebElement getReportAboutWrongEmail(){
        return reportAboutWrongEmail;
    }
    public WebElement getButtonOfClosePopup(){
        return buttonOfClosePopup;
    }
    public void clickButtonOfPopup(){
        buttonOfClosePopup.click();
    }
}
