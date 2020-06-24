package tests;

import org.testng.annotations.Test;

public class WorkspaceTest extends BaseTest {

    @Test
    public void inviteUser() {
        loginSteps.signIn("test42@mailinator.com");
        loginSteps.MailHogValidation("test42@mailinator.com");
        loginSteps.selectWorkspace("Test Workspace");
        workspaceSteps.inviteUsersByEnterEmail("welcomenewuser@mailinator.com");
        workspaceSteps.checkForInvitedUser("welcomenewuser@mailinator.com");
    }

    @Test
    public void createNewFolder(){
        loginSteps.signIn("test42@mailinator.com");
        loginSteps.MailHogValidation("test42@mailinator.com");
        loginSteps.selectWorkspace("Test Workspace");
        workspaceSteps.createANewFolder();
        workspaceSteps.checkNewFolder();
    }


}
