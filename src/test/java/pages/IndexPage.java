package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Matthias Veelaert r0704252 & Younes Mounnadi r0786792;
 * */

public class IndexPage extends pages.Page {

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver.get(path);
    }

    @FindBy(id = "userId")
    private WebElement userIdField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement LoginButton;

    public void setUseridField(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        LoginButton.click();
    }

    public boolean hasLogInForm() {
        return driver.findElement(By.name("logInForm")) != null;
    }

    public boolean containsLogInMessageWithText(String text) {
        WebElement logInP = this.driver.findElement(By.cssSelector("div.alert-danger"));
        if (logInP.getText().equals(text)) return true;
        return false;
    }

    public boolean containsErrorMessageWithText(String text) {
        List<WebElement> errorList = this.driver.findElement(By.className("alert-danger")).findElements(By.tagName("li"));
        for (WebElement li : errorList) {
            if (li.getText().equals(text)) return true;
        }
        return false;
    }
    public boolean containsUserId(String text) {
        WebElement loginUser = this.driver.findElement(By.cssSelector("div.ingelogd p"));
        if (loginUser.getText().equals(text)) return true;
        return false;
    }
}
