package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.LoginSteps;
import steps.WorkspaceSteps;
import utils.EmailGenerator;
import utils.FolderGenerator;


public class BaseTest {
    LoginSteps loginSteps;
    WorkspaceSteps workspaceSteps;
    EmailGenerator emailGenerator;
    FolderGenerator folderGenerator;


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
        workspaceSteps = new WorkspaceSteps();
        folderGenerator = new FolderGenerator();
    }

}
