package mobileTesting.activities.calendar;

import mobileTesting.appiumControl.Button;
import mobileTesting.appiumControl.TextBox;
import org.openqa.selenium.By;

public class CalendarActivities {
    public Button plusButton = new Button(By.id("com.simplemobiletools.calendar:id/calendar_fab"));
    public TextBox titleEvent = new TextBox(By.id("com.simplemobiletools.calendar:id/event_title"));
    public TextBox descriptionEvent = new TextBox(By.id("com.simplemobiletools.calendar:id/event_description"));
    public Button saveButton = new Button(By.id("com.simplemobiletools.calendar:id/save"));

    public Button changeView = new Button(By.id("com.simplemobiletools.calendar:id/change_view"));
    public Button eventList = new Button(By.xpath("//android.widget.RadioButton[@text='Simple event list']"));
    public Button eventCreated (String title){
        return new Button(By.xpath("//android.widget.TextView[@resource-id=\"com.simplemobiletools.calendar:id/event_item_title\" and @text='"+title+"']"));
    }
}
