package pages;

import com.codeborne.selenide.Condition;
import lombok.Data;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
public class MailHogPage {

    public String ValidationCode;
    private static final String URL = "https://autotest.leverice.net/email/";
    private static final String MESSAGES_CSS = ".messages";
    private static final String VALIDATION_CODE_CSS = ".validation-code";


    public void openPage() {
        open(URL);
        isPageOpened();
    }

    public void isPageOpened() {
        $(MESSAGES_CSS).waitUntil(Condition.visible, 10000);
    }

    public void getValidationCode(String email) {
        $(byText(email)).click();
        //тут нужно как-то переключить фрейм
        ValidationCode = $(VALIDATION_CODE_CSS).getText();
        System.out.println(ValidationCode);
    }

}
