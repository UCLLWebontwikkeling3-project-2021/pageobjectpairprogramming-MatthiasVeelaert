package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Matthias Veelaert r0704252 & Younes Mounnadi r0786792;
 * */

public class AccountPageUser extends pages.Page {

    public AccountPageUser(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Account");
    }


    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "changePassword")
    private WebElement changePasswordButton;

    @FindBy(id = "logOut")
    private WebElement logOutButton;

    @FindBy(id = "deleteAccount")
    private WebElement deleteButton;


    public boolean hasLogOutButton() {
        return driver.findElement(By.id("logOut")) != null;
    }

    public void setNewPasswordField(String newPassword) {
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);
    }

    public void submitNewPassword() {
        changePasswordButton.click();
    }

    public void submitNewPasswordInvalid() {
        changePasswordButton.click();
    }

    public void submitLogout() {
        logOutButton.click();
    }

    public void submitDelete() {
        deleteButton.click();
    }
}