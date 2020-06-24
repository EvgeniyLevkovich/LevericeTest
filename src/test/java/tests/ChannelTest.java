package tests;

import org.testng.annotations.Test;

public class ChannelTest extends BaseTest {

    @Test
    public void sendMessage() {
        String text = textGenerator.generateText();
        loginSteps.signIn("test42@mailinator.com");
        loginSteps.MailHogValidation("test42@mailinator.com");
        loginSteps.selectWorkspace("Test Workspace");
        channelSteps
                .openPage()
                .writeTextMessage(text)
                .sendTextMessage()
                .checkThatMessageSended(text);
    }
}
