package tercerParcial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.selenium.pagesTodoLy.LoginSection;
import webTesting.selenium.pagesTodoLy.MainPage;
import webTesting.selenium.pagesTodoLy.MenuSection;
import webTesting.selenium.pagesTodoLy.SignUpSection;
import webTesting.selenium.session.Session;
import webTesting.tareaCRUDTOKEN.ConfigurationTOKEN;

import java.util.Random;

public class ejercicio3CantCUser {

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

        mainPage.signupButton.click();
        signUpSection.fullName.setText("Vivian Marino");
        signUpSection.email.setText(nameUser);
        signUpSection.passwordSignUp.setText("12345");
        signUpSection.checkboxTerms.click();
        signUpSection.signUpButton.click();

        Thread.sleep(1000);

        Assertions.assertTrue(mainPage.accountAlreadyExists.isControlDisplayed(), "ERROR no se pudo hacer la comprobacion");

    }

}