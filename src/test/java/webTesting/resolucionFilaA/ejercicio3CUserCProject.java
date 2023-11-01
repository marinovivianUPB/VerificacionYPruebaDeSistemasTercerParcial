package webTesting.resolucionFilaA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.selenium.pagesTodoLy.LoginSection;
import webTesting.selenium.pagesTodoLy.MainPage;
import webTesting.selenium.pagesTodoLy.MenuSection;
import webTesting.selenium.pagesTodoLy.SignUpSection;
import webTesting.selenium.session.Session;

import java.util.Random;

public class ejercicio3CUserCProject {

    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    SignUpSection signUpSection = new SignUpSection();
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

        menuSection.logoutButton.click();

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText(nameUser);
        loginSection.passwordTextBox.setText("12345");
        loginSection.loginButton.click();

        nameProject="holiii";
        menuSection.addNewProjectButton.click();
        menuSection.projectNameInput.setText(nameProject);
        menuSection.addProjectButton.click();
        Thread.sleep(3000);

        Assertions.assertTrue(menuSection.projectJustCreated(nameProject).isControlDisplayed(), "ERROR no se pudo crear el proyecto");

    }

}