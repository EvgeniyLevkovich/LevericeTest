package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import steps.LoginSteps;

public class BaseTest {
    LoginSteps loginSteps;

    @BeforeClass
    public void setupBrowser() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
    }

    @BeforeMethod
    public void openBrowser() {
        loginSteps = new LoginSteps();
    }
}
