package tests;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void registrationTest() {
        loginSteps.registration( "Jack", "Daniels", "New Workspace");
    }

    @Test(priority = 2)
    public void login() {
        loginSteps.login("test42@mailinator.com","Test Workspace");
    }
}

/* используйте login() чтобы открыть Леврайс, после чего можно писать свои тесты.
 */
