package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import steps.LoginSteps;
import utils.EmailGenerator;

public class BaseTest {
    LoginSteps loginSteps;
    EmailGenerator emailGenerator;

    @BeforeClass
    public void setupBrowser() {
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
    }

    @BeforeMethod
    public void openBrowser() {
        loginSteps = new LoginSteps();
        emailGenerator = new EmailGenerator();
    }
}
