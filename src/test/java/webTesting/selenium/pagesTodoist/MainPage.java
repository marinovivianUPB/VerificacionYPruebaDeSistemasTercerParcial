package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//li//a[@href='/auth/login']"));

    public Button signupButton = new Button(By.xpath("//div[@class='intro-section_headersContainer__9NjnT YttEe7kIjjIAtcbhghld c8EWRT5sy9CxCZyUQe6w']//div[@class='ALjV_FDtdiJ2rGCAH1Lg SVhGiSzS0M7007sJ4mKJ']//a[@href='/auth/signup']"));
}
