package mobileTesting.activities.notepad;

import mobileTesting.appiumControl.Button;
import org.openqa.selenium.By;

public class Principal {
    public Button add = new Button(By.id("com.atomczak.notepat:id/new_note_fab"));

    public Button note(String titulo){
        return new Button(By.xpath("//android.widget.TextView[@text='"+titulo+"']"));
    }
}
