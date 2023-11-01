package tercerParcial;

import io.appium.java_client.AppiumDriver;
import mobileTesting.activities.whendo.AddTaskScreenActivity;
import mobileTesting.activities.whendo.ConfirmDeleteActivity;
import mobileTesting.activities.whendo.EditTaskScreenActivity;
import mobileTesting.activities.whendo.WhenDoMainActivity;
import mobileTesting.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class ejercicioMobile {
    AppiumDriver phone;
    WhenDoMainActivity main = new WhenDoMainActivity();
    AddTaskScreenActivity addTask = new AddTaskScreenActivity();

    EditTaskScreenActivity editTask = new EditTaskScreenActivity();

    ConfirmDeleteActivity confirm = new ConfirmDeleteActivity();
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
        main.itemCreated(titulo).click();
        editTask.setTitle.setText(titulo+" UPDATED");
        editTask.save.click();
        Assertions.assertTrue(main.itemCreated(titulo+" UPDATED").isControlDisplayed(),"ERROR no se actualizó el item");
        main.itemCreated(titulo+" UPDATED").click();
        editTask.deleteTask.click();
        confirm.deleteButton.click();
        Assertions.assertFalse(main.itemCreated(titulo+" UPDATED").isControlDisplayed(),"ERROR no se eliminó el item");
        Thread.sleep(10000);
    }

}
