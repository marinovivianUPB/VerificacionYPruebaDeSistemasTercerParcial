package mobileTesting.testsWithFactory;

import mobileTesting.activities.calendar.CalendarActivities;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mobileTesting.session.Session;

import java.util.Random;

public class CalendarTest {
    AppiumDriver phone;
    CalendarActivities cal = new CalendarActivities();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.simplemobiletools.calendar", "com.simplemobiletools.calendar.activities.MainActivity");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyCalculatorTest() throws InterruptedException {
        String titulo="EsteEsUnNuevoItem"+rand.nextInt(255);
        cal.plusButton.click();
        cal.titleEvent.setText(titulo);
        cal.descriptionEvent.setText("hola");
        cal.saveButton.click();
        cal.changeView.click();
        cal.eventList.click();
        Assertions.assertTrue(cal.eventCreated(titulo).isControlDisplayed(),"ERROR no se creó el evento");
        Thread.sleep(10000);
    }
}
