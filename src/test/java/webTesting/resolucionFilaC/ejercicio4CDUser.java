package webTesting.resolucionFilaC;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.selenium.pagesTodoLy.*;
import webTesting.selenium.session.Session;

import java.util.Random;

public class ejercicio4CDUser {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    SignUpSection signUpSection = new SignUpSection();

    SettingsPopUp settingsPopUp = new SettingsPopUp();
    static Random rand = new Random();

    static String nameUser;
    static String nameProject;

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void createUserLogInCreateProject() throws InterruptedException {

        mainPage.signupButton.click();

        nameUser="hola"+rand.nextInt(255)+rand.nextInt(255)+"@prueba.com";
        signUpSection.fullName.setText("Vivian Marino");
        signUpSection.email.setText(nameUser);
        signUpSection.passwordSignUp.setText("12345");
        signUpSection.checkboxTerms.click();
        signUpSection.signUpButton.click();

        menuSection.settings.click();

        settingsPopUp.accountButton.click();
        settingsPopUp.deleteButton.click();
        Session.getInstance().acceptWarning();

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(nameUser);
        loginSection.passwordTextBox.setText("12345");
        loginSection.loginButton.click();
        Thread.sleep(1500);

        Assertions.assertTrue(mainPage.errorMessage.isControlDisplayed(), "ERROR no se pudo eliminar al usuario");

    }
}
