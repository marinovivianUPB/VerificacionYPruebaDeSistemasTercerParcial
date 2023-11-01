package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class SignUpPage {
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox passwordTextBox = new TextBox(By.xpath("//input[@type='password']"));
    public Button signupButton = new Button(By.xpath("//button[@type='submit']"));
}
