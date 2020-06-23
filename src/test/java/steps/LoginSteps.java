package steps;

import pages.LoginPage;
import pages.MailHogPage;
import utils.EmailGenerator;

public class LoginSteps {
    LoginPage loginPage;
    MailHogPage mailHogPage;
    EmailGenerator emailGenerator;

    public LoginSteps() {
        loginPage = new LoginPage();
        mailHogPage = new MailHogPage();
        emailGenerator = new EmailGenerator();
    }

    public void registration(String firstName, String lastName, String newWorkspaceName) {
        emailGenerator.generateEmail();
        loginPage.openPage();
        loginPage.proceedToCreatingANewWorkspace(EmailGenerator.fakeEmail);
        mailHogPage.openPage();
        mailHogPage.getValidationCode(EmailGenerator.fakeEmail);
        mailHogPage.closeMailHog();
        loginPage.enterValidationCode();
        loginPage.fillIntroduceYourselfFields(firstName, lastName);
        loginPage.createWorkspace(newWorkspaceName);
        loginPage.closeTab();
    }

    public void login(String login, String workspaceName) {
        loginPage.openPage();
        loginPage.proceedToSignIn(login);
        mailHogPage.openPage();
        mailHogPage.getValidationCode(login);
        mailHogPage.closeMailHog();
        loginPage.enterValidationCode();
        loginPage.selectWorkspace(workspaceName);
    }
}
