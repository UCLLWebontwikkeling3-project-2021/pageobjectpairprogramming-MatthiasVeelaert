import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Matthias Veelaert r0704252 & Younes Mounnadi r0786792;
 **/

public class LogoutTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC-Matthias\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_LoggedInUserLogsOut_ProfilePageShownWithLogInForm() {
        //Register and log in
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setUserIdRegisterField("testuser");
        registerPage.setFirstNameRegisterField("Test");
        registerPage.setLastNameRegisterField("User");
        registerPage.setEmailRegisterField("Test.User@gmail.com");
        registerPage.setPasswordRegisterField("t");
        registerPage.submitRegister();
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        //assertTrue(indexPage.containsStatusMessageWithText("Your account has been registered"));

        indexPage.setUseridField("testuser");
        indexPage.setPasswordField("t");
        indexPage.submitLogin();
        AccountPageUser accountPageUser = PageFactory.initElements(driver, AccountPageUser.class);

        accountPageUser.submitDelete();
        DeletePage deletePage = PageFactory.initElements(driver, DeletePage.class);
        deletePage.submitDelete();
        assertTrue(indexPage.hasLogInForm());
        assertTrue(indexPage.containsStatusMessageWithText("Your account has been removed"));
    }

    @Test(expected = NoSuchElementException.class)
    public void test_GuestVisitsSite_CannotSeeLogOutButton() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        assertTrue(indexPage.hasLogInForm());
        AccountPageUser accountPageUser = PageFactory.initElements(driver, AccountPageUser.class);
        assertFalse(accountPageUser.hasLogOutButton());
    }
}