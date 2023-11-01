package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class ChangePasswordSection {
    public TextBox currentPassword = new TextBox(By.xpath("//input[@autocomplete='off' and @type='password']"));
    public TextBox newPassword = new TextBox(By.xpath("//span[text()='New password']/../../..//input"));
    public TextBox confirmNewPassword = new TextBox(By.xpath("//span[text()='Confirm new password']/../../..//input"));
    public Button changePasswordButton = new Button(By.xpath("//button[@type='submit']"));
}
