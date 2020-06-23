package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.LoginSteps;
import utils.EmailGenerator;

public class BaseTest {
    LoginSteps loginSteps;
    EmailGenerator emailGenerator;

    @BeforeSuite
    public void setupBrowser() {
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        emailGenerator = new EmailGenerator();
        emailGenerator.generateEmail();
        
    }

    @BeforeMethod
    public void openBrowser() {
        loginSteps = new LoginSteps();
        emailGenerator = new EmailGenerator();
    }
}
