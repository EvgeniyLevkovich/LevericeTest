package tests;

import org.testng.annotations.Test;

public class WorkspaceTest extends LoginTest {

    @Test
    public void inviteUser(){
        login();
        workspacePage.inviteUsersByEnterEmail("welcomenewuser@mailinator.com");
        workspacePage.checkForInvitedUser("welcomenewuser@mailinator.com");
    }
}
