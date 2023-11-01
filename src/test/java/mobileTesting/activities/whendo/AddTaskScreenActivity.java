package mobileTesting.activities.whendo;

import mobileTesting.appiumControl.Button;
import mobileTesting.appiumControl.TextBox;
import org.openqa.selenium.By;

public class AddTaskScreenActivity {
    public TextBox setTitle = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox setNotes = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button save = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
