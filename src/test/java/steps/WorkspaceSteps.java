package steps;

import pages.WorkspacePage;

public class WorkspaceSteps {
    WorkspacePage workspacePage;

    public WorkspaceSteps() {
        workspacePage = new WorkspacePage();
    }

    public void inviteUsersByEnterEmail(String userEmail) {
        workspacePage.clickInviteUser();
        workspacePage.inviteUser(userEmail);
    }

    public void checkForInvitedUser(String userEmail) {
        workspacePage.manageMembers();
        workspacePage.checkForInvitedUser(userEmail);
    }
}
