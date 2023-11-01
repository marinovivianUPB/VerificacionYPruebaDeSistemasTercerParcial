package webTesting.selenium.testTodoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.selenium.pagesTodoist.*;
import webTesting.selenium.session.Session;


public class ChangePasswordTodoistTest {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    WorkspacePage workspacePage = new WorkspacePage();
    ProfilePopUp profilePopUp = new ProfilePopUp();
    ProfileSettingsPopUp profileSettingsPopUp = new ProfileSettingsPopUp();
    ChangePasswordSection changePasswordSection = new ChangePasswordSection();

    String email = "prueba65785@prueba65785.com";
    String password = "abc456gh912";

    String newPassword = "abc456gh913";

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }

    @BeforeEach
    public void open() throws InterruptedException {
        Session.getInstance().getBrowser().get("https://todoist.com/");
        mainPage.loginButton.click();
        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(password);
        loginPage.loginButton.click();
        Thread.sleep(10000);
    }
    @Test
    public void changePasswordTest() throws InterruptedException {
        workspacePage.profileButton.click();
        Thread.sleep(1000);
        profilePopUp.settingsButton.click();
        Thread.sleep(2000);
        profileSettingsPopUp.changePasswordButton.click();
        Thread.sleep(3000);
        changePasswordSection.currentPassword.setText(password);
        changePasswordSection.newPassword.setText(newPassword);
        changePasswordSection.confirmNewPassword.setText(newPassword);
        changePasswordSection.changePasswordButton.click();
        Thread.sleep(5000);
        profileSettingsPopUp.closeButton.click();
        Thread.sleep(1000);
        workspacePage.profileButton.click();
        profilePopUp.logoutButton.click();
        Thread.sleep(3000);
        mainPage.loginButton.click();
        Thread.sleep(3000);
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(newPassword);
        loginPage.loginButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(workspacePage.profileButton.isControlDisplayed(), "ERROR no se pudo cambiar de contraseña");
    }
}