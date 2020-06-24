package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Log4j2
public class ChannelPage {

    private static final String MESSAGE_SECTION = ".create-message-section";
    private static final String INPUT_MESSAGE = "//*[@id='input-message']/p";
    private static final String BUTTON = "//*[@class='send-button']";
    private static final String TEXT_MESSAGE = "//*[@class = 'message-render']/span/p";

    public ChannelPage isPageOpened() {
        $(MESSAGE_SECTION).shouldBe(Condition.visible);
    return this;
    }
    public ChannelPage clickField() {
        $(INPUT_MESSAGE).click();
        return this;
    }
    public ChannelPage enterText(String textMessage) {
        $(INPUT_MESSAGE).sendKeys(textMessage);
        return this;
    }
    public ChannelPage clickEnterButton() {
/*        while (true) {
            if ($$(BUTTON).size() == 0)
                log.info("Check that the button has become clickable");
            break;
            }*/
        //$(BUTTON).click();
        //        $(BUTTON).waitUntil(Condition.visible, 5000);
        $(INPUT_MESSAGE).sendKeys(Keys.ENTER);
        return this;
    }
    public ChannelPage checkTextMessage(String textMessage) {
        //*[@class = 'message-render']/span/p
        ElementsCollection list = $$(TEXT_MESSAGE);
        boolean isEquals;
        for(int i = 0; i <list.size(); i++) {
            String textInSendedMessage = list.get(i).text();
            isEquals = textInSendedMessage.contains(textMessage);
            if(isEquals){
               // log.print(textInSendedMessage);
                break;
            }
        }
        return this;
    }
}
