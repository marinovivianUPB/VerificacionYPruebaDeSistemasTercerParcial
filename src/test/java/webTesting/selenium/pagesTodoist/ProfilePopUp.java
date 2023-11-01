package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;

public class ProfilePopUp {
    public Button settingsButton = new Button(By.xpath("//span[@class='user_menu_label' and text()='Settings']"));
    public Button logoutButton = new Button(By.xpath("//span[text()='Log out']/.."));


    public Button userName(String name){
        return new Button(By.xpath("//strong[text()='"+name+"']"));
    }
}
