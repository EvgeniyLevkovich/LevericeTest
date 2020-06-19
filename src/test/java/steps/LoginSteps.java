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
        loginPage.proceedToCreatingANewWorkspace(emailGenerator.fakeEmail);
        mailHogPage.openPage();
        mailHogPage.getValidationCode(emailGenerator.fakeEmail);
        mailHogPage.closeMailHog();
        loginPage.enterValidationCode();
        loginPage.fillIntroduceYourselfFields(firstName, lastName);
        loginPage.createWorkspace(newWorkspaceName);
    }
}
