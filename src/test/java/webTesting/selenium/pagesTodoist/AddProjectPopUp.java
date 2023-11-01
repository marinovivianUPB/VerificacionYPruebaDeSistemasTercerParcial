package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class AddProjectPopUp {
    public TextBox projectName = new TextBox(By.id("edit_project_modal_field_name"));
    public Button addButton = new Button(By.xpath("//button[@type='submit']"));
}
