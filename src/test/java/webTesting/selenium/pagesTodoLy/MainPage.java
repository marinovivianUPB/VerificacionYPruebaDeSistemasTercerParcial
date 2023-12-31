package webTesting.selenium.pagesTodoLy;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;

public class MainPage {

    public Button accountAlreadyExists = new Button(By.xpath("//span[text()='Account with this email address already exists!']"));
    public Button errorMessage = new Button(By.id("ErrorMessageText"));
    public Button signupButton = new Button(By.xpath("//img[@src='/Images/design/pagesignup.png']"));
    public Button loginButton = new Button(By.xpath("//img[@src='/Images/design/pagelogin.png']"));
}
