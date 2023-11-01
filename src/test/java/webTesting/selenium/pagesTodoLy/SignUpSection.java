package webTesting.selenium.pagesTodoLy;

import org.openqa.selenium.By;
import webTesting.selenium.control.Button;
import webTesting.selenium.control.TextBox;

public class SignUpSection {

    public TextBox fullName = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox email = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox passwordSignUp = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Button checkboxTerms = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signUpButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
}
