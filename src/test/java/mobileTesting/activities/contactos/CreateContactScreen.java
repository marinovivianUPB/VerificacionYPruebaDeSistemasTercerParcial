package mobileTesting.activities.contactos;

import mobileTesting.appiumControl.Button;
import mobileTesting.appiumControl.TextBox;
import org.openqa.selenium.By;

public class CreateContactScreen {
    public TextBox firstName = new TextBox(By.xpath("//android.widget.EditText[@text='First name']"));
    public TextBox lastName = new TextBox(By.xpath("//android.widget.EditText[@text='Last name']"));
    public Button save = new Button(By.id("com.android.contacts:id/editor_menu_save_button"));
}
