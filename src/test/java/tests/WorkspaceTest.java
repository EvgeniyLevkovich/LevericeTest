package tests;

import org.testng.annotations.Test;

public class WorkspaceTest extends LoginTest {

    @Test
    public void inviteUser() {
        login();
        workspaceSteps.inviteUsersByEnterEmail("welcomenewuser@mailinator.com");
        workspaceSteps.checkForInvitedUser("welcomenewuser@mailinator.com");
    }
}
