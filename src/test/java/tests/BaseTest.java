package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import pages.MailHogPage;
import steps.LoginSteps;
import steps.WorkspaceSteps;
import utils.EmailGenerator;
import utils.FolderGenerator;
import pages.LoginPage;
import steps.ChannelSteps;
import utils.TextGenerator;
import utils.EmailGenerator;

public class BaseTest {
    LoginSteps loginSteps;
    LoginTest loginTest;
    LoginPage loginPage;
    WorkspaceSteps workspaceSteps;
    ChannelTest channelTest;
    ChannelSteps channelSteps;
    EmailGenerator emailGenerator;
    FolderGenerator folderGenerator;
    TextGenerator textGenerator;
    MailHogPage mailHogPage;
 


    @BeforeMethod
    public void openBrowser() {
        Configuration.holdBrowserOpen = true;
        loginSteps = new LoginSteps();
        loginTest = new LoginTest();
        loginPage = new LoginPage();
        emailGenerator = new EmailGenerator();
        workspaceSteps = new WorkspaceSteps();
        folderGenerator = new FolderGenerator();
        channelTest = new ChannelTest();
        channelSteps = new ChannelSteps();
        textGenerator = new TextGenerator();
        mailHogPage = new MailHogPage();
    }

    @AfterMethod

    public void closeBrowser()
    {
        Selenide.closeWebDriver();
    }
}
