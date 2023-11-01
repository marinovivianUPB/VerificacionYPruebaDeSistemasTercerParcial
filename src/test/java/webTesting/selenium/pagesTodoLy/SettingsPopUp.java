package webTesting.selenium.pagesTodoLy;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class SettingsPopUp {

    public Button accountButton = new Button(By.xpath("//a[text()='Account']"));

    public Button deleteButton = new Button(By.xpath("//input[@type='submit' and @name='DeleteAccountBtn']"));
    public TextBox fullNameInput = new TextBox(By.id("FullNameInput"));
    public TextBox oldPassword = new TextBox(By.id("TextPwOld"));
    public TextBox newPassword = new TextBox(By.id("TextPwNew"));
    public Button okButton = new Button(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']"));
}
