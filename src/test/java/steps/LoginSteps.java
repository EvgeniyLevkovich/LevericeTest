package steps;

import pages.LoginPage;
import pages.MailHogPage;

public class LoginSteps {
    LoginPage loginPage;
    MailHogPage mailHogPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        mailHogPage = new MailHogPage();
    }

    public void login(String email, String WorkspaceName) {
        loginPage.openPage();
        loginPage.proceedToCreatingANewWorkspace(email);
        mailHogPage.openPage();
        mailHogPage.getValidationCode(email);
        loginPage.openPage();
        loginPage.proceedToCreatingANewWorkspace(email);
        loginPage.enterValidationCode();


    }
}
