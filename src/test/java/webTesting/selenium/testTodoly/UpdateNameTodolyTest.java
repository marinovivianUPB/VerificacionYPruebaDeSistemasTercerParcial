package webTesting.selenium.testTodoly;

import org.junit.jupiter.api.*;
import webTesting.selenium.pagesTodoLy.LoginSection;
import webTesting.selenium.pagesTodoLy.MainPage;
import webTesting.selenium.pagesTodoLy.MenuSection;
import webTesting.selenium.pagesTodoLy.SettingsPopUp;
import webTesting.selenium.session.Session;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UpdateNameTodolyTest {

    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    SettingsPopUp settingsPopUp = new SettingsPopUp();

    static Random rand = new Random();
    static String fullName;

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open() throws InterruptedException {
        Session.getInstance().getBrowser().get("http://todo.ly/");
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("upbapi@prueba4.com");
        loginSection.passwordTextBox.setText("12345");
        loginSection.loginButton.click();
        Thread.sleep(3000);
    }

    @Test
    @Order(1)
    public void updateFullName() throws InterruptedException{
        fullName="VivianMarino"+rand.nextInt(500)+rand.nextInt(500);
        menuSection.settings.click();
        settingsPopUp.fullNameInput.clearTextField();
        settingsPopUp.fullNameInput.setText(fullName);
        settingsPopUp.okButton.click();
        menuSection.settings.click();
        String result = settingsPopUp.fullNameInput.getInput();
        Assertions.assertEquals(fullName, result, "ERROR: no se pudo cambiar el nombre");
    }
}
