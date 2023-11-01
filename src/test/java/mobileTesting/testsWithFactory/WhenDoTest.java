package mobileTesting.testsWithFactory;

import mobileTesting.activities.whendo.AddTaskScreenActivity;
import mobileTesting.activities.whendo.WhenDoMainActivity;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mobileTesting.session.Session;

import java.util.Random;

public class WhenDoTest {
    AppiumDriver phone;
    WhenDoMainActivity main = new WhenDoMainActivity();
    AddTaskScreenActivity addTask = new AddTaskScreenActivity();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.vrproductiveapps.whendo", "com.vrproductiveapps.whendo.ui.HomeActivity");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyCreateTask() throws InterruptedException {
        String titulo="EsteEsUnNuevoItem"+rand.nextInt(255);
        main.newItem.click();
        addTask.setTitle.setText(titulo);
        addTask.setNotes.setText("hola");
        addTask.save.click();
        Assertions.assertTrue(main.itemCreated(titulo).isControlDisplayed(),"ERROR no se creó el item");
        Thread.sleep(10000);
    }

}
