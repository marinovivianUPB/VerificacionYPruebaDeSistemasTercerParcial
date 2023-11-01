package mobileTesting.testsWithFactory;

import mobileTesting.activities.pigments.*;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mobileTesting.session.Session;

import java.util.Random;

public class PigmentsTest {
    AppiumDriver phone;
    Menu menu = new Menu();
    Options options = new Options();
    OptionsTheme optionsTheme = new OptionsTheme();
    PlusPremium premium = new PlusPremium();
    Principal principal=new Principal();

    Tutorial tutorial = new Tutorial();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.sorincovor.pigments", "com.sorincovor.pigments.MainActivity");
    }

    @AfterEach
    public void closeApp() throws InterruptedException {
        Thread.sleep(5000);
        options.theme.click();
        Thread.sleep(3000);
        optionsTheme.light.click();
        Session.getSession().closeApp();
    }

    @Test
    public void verifyThemeChanged() throws InterruptedException {
        tutorial.skip.click();
        Thread.sleep(5000);
        premium.equis.click();
        Thread.sleep(3000);
        principal.menu.click();
        menu.options.click();
        Thread.sleep(5000);
        options.theme.click();
        Thread.sleep(5000);
        optionsTheme.dark.click();
        Thread.sleep(5000);
        principal.menu.click();
        menu.options.click();
        Assertions.assertTrue(options.selectedThemeDark.isControlDisplayed(),"ERROR no se cambió el tema");
        Thread.sleep(10000);
    }
}
