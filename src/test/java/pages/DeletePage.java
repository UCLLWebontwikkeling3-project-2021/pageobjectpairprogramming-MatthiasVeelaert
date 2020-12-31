package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Matthias Veelaert r0704252 & Younes Mounnadi r0786792;
 * */

public class DeletePage extends pages.Page {

    public DeletePage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=DeleteConfirmation");
    }

    @FindBy(id = "noDelete")
    private WebElement noDeleteButton;


    @FindBy(id = "delete")
    private WebElement deleteButton;


    public void submitNoDelete() {
        noDeleteButton.click();
    }


    public void submitDelete() {
        deleteButton.click();
    }
}