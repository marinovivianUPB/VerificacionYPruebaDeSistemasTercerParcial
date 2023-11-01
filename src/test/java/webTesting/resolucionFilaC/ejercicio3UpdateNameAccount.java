package webTesting.resolucionFilaC;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import webTesting.selenium.pagesTodoist.*;
import webTesting.selenium.session.Session;

import java.util.Random;

public class ejercicio3UpdateNameAccount {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    WorkspacePage workspacePage = new WorkspacePage();

    ProfileSettingsPopUp profileSettingsPopUp = new ProfileSettingsPopUp();
    ProfilePopUp profilePopUp = new ProfilePopUp();
    AddTaskSection addTaskSection = new AddTaskSection();
    String email = "prueba65785@prueba65785.com";
    String password = "abc456gh913";

    static Random rand = new Random();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://todoist.com/");
    }
    @Test
    public void loginTesting() throws InterruptedException {
        mainPage.loginButton.click();
        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(password);
        loginPage.loginButton.click();
        Thread.sleep(10000);
        workspacePage.profileButton.click();
        String newName = "VivianMarino"+rand.nextInt(500)+rand.nextInt(500);
        profilePopUp.settingsButton.click();
        profileSettingsPopUp.name.clearTextField();
        profileSettingsPopUp.name.setText(newName+Keys.ENTER);
        profileSettingsPopUp.closeButton.click();
        workspacePage.profileButton.click();
        Assertions.assertTrue(profilePopUp.userName(newName).isControlDisplayed(), "ERROR no se pudo crear un nuevo task");
    }
}
