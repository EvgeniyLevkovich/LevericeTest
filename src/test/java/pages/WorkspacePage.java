package pages;

import com.codeborne.selenide.Condition;
import java.util.List;
import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkspacePage {

    private static final String INVITE_USERS_BUTTON = "Invite Users";
    private static final String ACTION_BUTTON = ".action-button";
    private static final String INVITE_USERS_BY_EMAIL = "//textarea[@placeholder='Enter email addresses (or paste multiple)']";
    private static final String TO_OPEN_OPTIONS_LOCATOR  ="//*[@data-name='Announcements']//*[@class='channel-settings-icon']";
    private static final String CHOOSE_MANAGE_MEMBERS_OPTION = "Manage Members";
    private static final String LIST_OF_USERS = ".user-card__fullName";
    private static final String CANCEL_BUTTON = "Cancel";


    public void clickInviteUser() {
        $(byText(INVITE_USERS_BUTTON)).click();
        $(byCssSelector(ACTION_BUTTON)).waitUntil(Condition.visible, 10000);
    }

    public void inviteUser(String userEmail) {
        $(byXpath(INVITE_USERS_BY_EMAIL)).sendKeys(userEmail);
        $(byCssSelector(ACTION_BUTTON)).click();
    }

    public void manageMembers() {
        $(byXpath(TO_OPEN_OPTIONS_LOCATOR)).click();
        $(byText(CHOOSE_MANAGE_MEMBERS_OPTION)).click();
    }

    public void checkForInvitedUser(String userEmail) {
        List<String> allUsers = $$(byCssSelector(LIST_OF_USERS)).texts();
        System.out.println("Channel members: " + allUsers);
        $$(byCssSelector(LIST_OF_USERS)).contains(exactValue(userEmail));
        System.out.println("Invited User: " + userEmail);
        $(byText(CANCEL_BUTTON)).click();
    }


}
