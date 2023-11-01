package mobileTesting.testsWithFactory;

import mobileTesting.activities.contactos.*;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mobileTesting.session.Session;

import java.util.Random;

public class ContactTest {
    AppiumDriver phone;
    Taskbar taskbar = new Taskbar();
    ContactsMainScreen main = new ContactsMainScreen();
    CreateContactScreen createScreen = new CreateContactScreen();
    ContactScreen created = new ContactScreen();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.google.android.dialer", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyCreateContact() throws InterruptedException {
        String nombre="Pepe"+rand.nextInt(255);
        taskbar.contacts.click();
        main.createNewContactEmptyList.click();
        createScreen.firstName.setText(nombre);
        createScreen.save.click();
        Assertions.assertEquals(nombre,created.contactCreated.getText(),"ERROR no se creó el contacto");
        Thread.sleep(10000);
    }
}
