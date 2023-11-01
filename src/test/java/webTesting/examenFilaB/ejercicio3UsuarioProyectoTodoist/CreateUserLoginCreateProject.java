package webTesting.examenFilaB.ejercicio3UsuarioProyectoTodoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.selenium.pagesTodoist.*;
import webTesting.selenium.pagesTodoist.MainPage;
import webTesting.selenium.pagesTodoist.WorkspacePage;
import webTesting.selenium.session.Session;

import java.util.Random;

public class CreateUserLoginCreateProject {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    SignUpPage signUpPage = new SignUpPage();
    CreateProfileSection1Page section1Page = new CreateProfileSection1Page();
    CreateProfileSection2Page section2Page = new CreateProfileSection2Page();

    ProfilePopUp profilePopUp = new ProfilePopUp();
    WorkspacePage workspacePage = new WorkspacePage();

    ProjectWorkspaceSection projectWorkspaceSection = new ProjectWorkspaceSection();
    AddProjectPopUp addProjectPopUp = new AddProjectPopUp();

    static String email;
    String password = "abc456gh9";

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
        email = "VivianMarino"+rand.nextInt(500)+rand.nextInt(500)+"@prueba.com";

        mainPage.signupButton.click();
        signUpPage.emailTextBox.setText(email);
        signUpPage.passwordTextBox.setText(password);
        signUpPage.signupButton.click();

        section1Page.profileName.setText("Vivian Marino");
        section1Page.continueButton.click();

        section2Page.personalButton.click();
        section2Page.noHelp.click();
        Thread.sleep(1500);
        section2Page.continueButton.click();

        workspacePage.profileButton.click();
        profilePopUp.logoutButton.click();

        mainPage.loginButton.click();
        loginPage.emailTextBox.setText(email);
        loginPage.passwordTextBox.setText(password);
        loginPage.loginButton.click();

        workspacePage.projects.click();
        projectWorkspaceSection.addProjectButton.click();

        String projectName="Este es un proyecto";
        addProjectPopUp.projectName.setText(projectName);
        addProjectPopUp.addButton.click();


        Assertions.assertTrue(projectWorkspaceSection.projectCreated(projectName).isControlDisplayed(), "ERROR no se pudo crear el proyecto");
    }
}
