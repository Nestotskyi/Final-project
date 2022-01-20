package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;
    public PageFactoryManager(WebDriver driver){this.driver=driver;}
    public HomePage getHomePage(){return new HomePage(driver);}
    public ContactBBCPage getContactBBCPage(){return new ContactBBCPage(driver);}
    public CoronavirusPage getCoronavirusPage(){return new CoronavirusPage(driver);}
    public NewsPage getNewsPage(){return new NewsPage(driver);}
    public ShareNewsPage getShareNewsPage(){return new ShareNewsPage(driver);}
    public SearchResultPage getSearchResultPage(){return new SearchResultPage(driver);}

}
