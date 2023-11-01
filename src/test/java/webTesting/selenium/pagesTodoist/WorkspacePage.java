package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;

public class WorkspacePage {
    public Button profileButton = new Button(By.xpath("//button[@aria-label='Settings']"));

    public Button projects = new Button(By.xpath("//a[@href='/app/projects']"));

    public Button addTask = new Button(By.xpath("//button[@class='plus_add_button']"));

}
