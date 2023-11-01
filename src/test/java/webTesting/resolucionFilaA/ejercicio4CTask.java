package webTesting.resolucionFilaA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webTesting.selenium.pagesTodoist.*;
import webTesting.selenium.pagesTodoist.LoginPage;
import webTesting.selenium.pagesTodoist.MainPage;
import webTesting.selenium.session.Session;

import java.util.Random;

public class ejercicio4CTask {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    WorkspacePage workspacePage = new WorkspacePage();

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
        workspacePage.addTask.click();
        String taskName = "VivianMarino"+rand.nextInt(500)+rand.nextInt(500);
        addTaskSection.taskName.setText(taskName);
        addTaskSection.description.setText("Un nuevo task");
        addTaskSection.addTaskButton.click();
        Assertions.assertTrue(addTaskSection.newTaskCreated(taskName).isControlDisplayed(), "ERROR no se pudo crear un nuevo task");
    }
}
