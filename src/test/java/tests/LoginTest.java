package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        loginSteps.login("test2@mail.ru", "test1");
    }
}
