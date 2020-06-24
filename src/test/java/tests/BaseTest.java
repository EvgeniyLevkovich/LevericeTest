package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.MailHogPage;
import steps.LoginSteps;
import steps.WorkspaceSteps;
import utils.EmailGenerator;
import utils.FolderGenerator;
import pages.LoginPage;
import steps.ChannelSteps;
import utils.TextGenerator;

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
}
