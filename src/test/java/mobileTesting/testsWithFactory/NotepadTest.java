package mobileTesting.testsWithFactory;

import mobileTesting.activities.notepad.*;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mobileTesting.session.Session;

import java.util.Random;

public class NotepadTest {
    AppiumDriver phone;

    Principal principal=new Principal();
    CreacionNota creacionNota = new CreacionNota();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.atomczak.notepat", "com.atomczak.notepat.MainActivity");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyNoteCreated() throws InterruptedException {
        String titulo="EsteEsUnNuevoItem"+rand.nextInt(255);
        String cuerpo = "Este es el cuerpo de la nota que estamos creando en este momento, no es relevante";
        principal.add.click();
        creacionNota.titulo.setText(titulo);
        creacionNota.cuerpo.setText(cuerpo);
        creacionNota.save.click();
        creacionNota.atras.click();
        Assertions.assertTrue(principal.note(titulo).isControlDisplayed(),"ERROR no se creó la nota");
        Thread.sleep(10000);
    }
}
