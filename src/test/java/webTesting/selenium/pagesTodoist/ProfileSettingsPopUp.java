package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class ProfileSettingsPopUp {
    public Button changePasswordButton = new Button(By.xpath("//a[@class='_8313bd46 _54d56775 _5e45d59f _2a3b75a1 _56a651f6' and @href='/app/settings/account/password']"));

    public TextBox name = new TextBox(By.xpath("//input[@name='name']"));
    public Button closeButton = new Button(By.xpath("//button[@aria-label='Close settings']"));
}
