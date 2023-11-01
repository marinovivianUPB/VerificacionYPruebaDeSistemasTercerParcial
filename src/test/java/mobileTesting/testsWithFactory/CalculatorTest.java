package mobileTesting.testsWithFactory;

import mobileTesting.activities.calculator.CalculatorActivities;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mobileTesting.session.Session;

public class CalculatorTest {
    AppiumDriver phone;
    CalculatorActivities calc = new CalculatorActivities();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.android.calculator2", "com.android.calculator2.Calculator");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyCalculatorTest() throws InterruptedException {
        calc.fiveButton.click();
        calc.addButton.click();
        calc.sevenButton.click();
        calc.equalButton.click();
        String actualResult= calc.resultLabel.getText();
        String expectedResult="12";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma esta mal");
        Thread.sleep(10000);
    }
}
