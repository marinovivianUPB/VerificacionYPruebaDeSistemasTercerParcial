package webTesting.selenium.session;
import org.openqa.selenium.WebDriver;
import webTesting.selenium.factoryBrowser2.FactoryBrowser;

import java.time.Duration;

public class Session {
    private static Session session;
    private WebDriver browser;
    private Session(){
        browser = FactoryBrowser.make("chrome").create();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public static Session getInstance(){
        if (session == null)
            session = new Session();
        return session;
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public void closeSession(){
        browser.quit();
        session = null;
    }

    public void acceptWarning(){
        browser.switchTo().alert().accept();
    }
}
