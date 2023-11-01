package webTesting.selenium.pagesTodoist;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class AddTaskSection {
    public TextBox taskName = new TextBox(By.xpath("//p[@data-placeholder='Task name']"));
    public TextBox description = new TextBox(By.xpath("//p[@data-placeholder='Description']"));
    public Button addTaskButton = new Button(By.xpath("//button[@data-testid='task-editor-submit-button']"));

    public Button newTaskCreated(String name){
        return new Button(By.xpath("//*[text()='"+name+"']/../../../../../../../../../../../.."));
    }
}
