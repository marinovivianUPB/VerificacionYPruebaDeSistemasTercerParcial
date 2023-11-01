package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;
public class LoginPage {
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox passwordTextBox = new TextBox(By.xpath("//input[@type='password']"));
    public Button loginButton = new Button(By.xpath("//button[@type='submit']"));
}
