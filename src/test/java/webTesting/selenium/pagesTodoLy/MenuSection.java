package webTesting.selenium.pagesTodoLy;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox projectNameInput = new TextBox(By.id("NewProjNameInput"));
    public Button addProjectButton = new Button(By.id("NewProjNameButton"));
    public TextBox addItemInput = new TextBox(By.id("NewItemContentInput"));
    public Button addItemButton = new Button(By.id("NewItemAddButton"));
    public Button settings = new Button(By.xpath("//a[text()='Settings']"));


    public Button projectJustCreated(String projectName){
        return new Button(By.xpath("//ul[@id='mainProjectList']//li//td[text()='"+projectName+"']"));
    }

    public Button itemJustCreated(String item){
        return new Button(By.xpath("//div[@class='ItemContentDiv' and text()='"+item+"']"));
    }

    public TextBox itemJustCreatedInput(){
        return new TextBox(By.xpath("//div[@class='ItemContentDiv UnderEditingItem']//div[@id='ItemEditDiv']//textarea[@id='ItemEditTextbox']"));
    }

}
