package mobileTesting.appiumControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import mobileTesting.session.Session;

public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator){
        this.locator = locator;
    }

    public void findControl(){
        control = Session.getSession().getDevice().findElement(this.locator);
    }

    public void click(){
        findControl();
        control.click();
    }

    public String getText(){
        findControl();
        return control.getText();
    }

    public boolean isControlDisplayed(){
        try {
            findControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }
}
