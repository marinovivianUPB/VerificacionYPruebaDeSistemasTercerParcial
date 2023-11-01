package webTesting.selenium.control;

import org.openqa.selenium.By;

public class TextBox extends Control{

    public TextBox(By locator) {
        super(locator);
    }

    public void setText(String text){
        getControl();
        this.control.sendKeys(text);
    }

    public void clearTextField(){
        getControl();
        this.control.clear();
    }

    public String getInput(){
        getControl();
        return this.control.getAttribute("value");
    }
}
