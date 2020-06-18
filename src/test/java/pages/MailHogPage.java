package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Data
public class MailHogPage {

    public String ValidationCode;
    private static final String URL = "https://autotest.leverice.net/email/";
    private static final String MESSAGES_CSS = ".messages";
    private static final String VALIDATION_CODE_CSS = ".validation-code";
    private static final String IFRAME_ID = "preview-html";

    public void openPage() {
        open(URL);
        isPageOpened();
    }

    public void isPageOpened() {
        $(MESSAGES_CSS).waitUntil(Condition.visible, 10000);
    }

    public void getValidationCode(String email) {
        $(byText(email)).click();
        switchTo().frame(IFRAME_ID);
        ValidationCode = $(VALIDATION_CODE_CSS).getText();
    }

}
