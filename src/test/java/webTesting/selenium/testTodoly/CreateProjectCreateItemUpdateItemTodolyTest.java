package webTesting.selenium.testTodoly;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import webTesting.selenium.pagesTodoLy.LoginSection;
import webTesting.selenium.pagesTodoLy.MainPage;
import webTesting.selenium.pagesTodoLy.MenuSection;
import webTesting.selenium.session.Session;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateProjectCreateItemUpdateItemTodolyTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    static Random rand = new Random();
    static String nameProject;

    static String newItem;
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
    public void createProject() throws InterruptedException {
        nameProject="VivianMarino"+rand.nextInt(500)+rand.nextInt(500);
        menuSection.addNewProjectButton.click();
        Thread.sleep(2000);
        menuSection.projectNameInput.setText(nameProject);
        Thread.sleep(2000);
        menuSection.addProjectButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(menuSection.projectJustCreated(nameProject).isControlDisplayed(), "ERROR no se pudo crear el proyecto");
    }

    @Test
    @Order(2)
    public void createItem() throws InterruptedException{
        newItem = "Tarea Verificacion y Prueba de Sistemas";
        menuSection.projectJustCreated(nameProject).click();
        Thread.sleep(3000);
        menuSection.addItemInput.setText(newItem);
        menuSection.addItemButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(menuSection.itemJustCreated(newItem).isControlDisplayed(), "ERROR no se pudo crear el item");
    }

    @Test
    @Order(3)
    public void updateItem() throws InterruptedException{
        String update = "UPDATED";
        menuSection.projectJustCreated(nameProject).click();
        Thread.sleep(3000);
        menuSection.itemJustCreated(newItem).click();
        menuSection.itemJustCreatedInput().setText(update+Keys.RETURN);
        Thread.sleep(3000);
        Assertions.assertTrue(menuSection.itemJustCreated(newItem+update).isControlDisplayed(), "ERROR no se pudo actualizar el item");
    }
}
