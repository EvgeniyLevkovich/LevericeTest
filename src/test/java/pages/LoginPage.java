package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String URL = "https://autotest.leverice.net/public/client/";
    private static final String LOGIN_PAGE_IMAGE_CSS = ".tutorial-img__content";
    private static final String CREATE_WORKSPACE_TEXT = "Create a new Workspace";
    private static final String EMAIL_NAME = "email";
    private static final String CONTINUE_BUTTON_TEXT = "Continue";
    private static final String VALIDATION_CODE_FIELD_CSS = "input[inputmode=numeric]";

    public void openPage() {
        open(URL);
        isPageOpened();
    }

    public void isPageOpened() {
        $(LOGIN_PAGE_IMAGE_CSS).waitUntil(Condition.visible, 10000);
    }

    public void proceedToCreatingANewWorkspace(String email) {
        $(byText(CREATE_WORKSPACE_TEXT)).click();
        $(byName(EMAIL_NAME)).sendKeys(email);
        $(byText(CONTINUE_BUTTON_TEXT)).click();
    }
    public void enterValidationCode() {
        $(VALIDATION_CODE_FIELD_CSS).sendKeys(MailHogPage.validationCode);
    }
}
