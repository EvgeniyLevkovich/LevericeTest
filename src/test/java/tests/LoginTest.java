package tests;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void registrationTest() {
        loginSteps.registration( "Jack", "Daniels", "New Workspace");
    }
}

/* При написании тестов ставьте  loginSteps.registration первым шагом, после чего открывается дэшборд Леврайса,
 и следющими степами уже пишете свои тесты. Считаете это как openPage();
 */
