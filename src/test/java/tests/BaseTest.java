package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.WorkspacePage;
import steps.LoginSteps;
import utils.EmailGenerator;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginSteps loginSteps;
    EmailGenerator emailGenerator;
    WorkspacePage workspacePage;

    @BeforeSuite
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
        workspacePage = new WorkspacePage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        getWebDriver().quit();
    }
}
