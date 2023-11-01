package mobileTesting.activities.calculator;

import mobileTesting.appiumControl.Button;
import org.openqa.selenium.By;

public class CalculatorActivities {
    public Button fiveButton = new Button(By.xpath("//android.widget.Button[@text='5']"));
    public Button sevenButton = new Button(By.xpath("//android.widget.Button[@text='7']"));
    public Button addButton = new Button(By.xpath("//android.widget.Button[@text='+']"));
    public Button equalButton = new Button(By.xpath("//android.widget.Button[@content-desc=\"equals\"]"));

    public Button resultLabel = new Button(By.xpath("//android.widget.TextView[@resource-id=\"com.android.calculator2:id/result\"]"));
}
