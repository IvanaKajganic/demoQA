package bookStoreApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    WebDriver driver;
    By logout = By.id("submit");
    By goToStoreButton = By.id("gotoStore");
    By footers = By.id("submit");
    By modalOk = By.id("closeSmallModal-ok");
    By modalCancel = By.id("closeSmallModal-cancel");
    By row = By.className("rt-tr-group");
    By trashBin = By.id("delete-record-undefined");

    public Profile(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLogout() {
        return driver.findElement(logout);
    }
    public WebElement getGoToStoreButton() {
        return driver.findElement(goToStoreButton);
    }
    public List<WebElement> getFooterButtons() {
        return driver.findElements(footers);
    }
    public WebElement getDeleteAccount() {
        return getFooterButtons().get(1);
    }
    public WebElement getDeleteAllBooks() {
        return getFooterButtons().get(2);
    }
    public WebElement getModalOk() {
        return driver.findElement(modalOk);
    }
    public WebElement getModalCancel() {
        return driver.findElement(modalCancel);
    }
    public List<WebElement> getRows() {
        List<WebElement> rows = new ArrayList<>();
        for(WebElement we : driver.findElements(row)){
            if(!(we.getText().isBlank())) {
                rows.add(we);
            }
        }
        return rows;
    }
    public WebElement getRow(int index){
        return getRows().get(index);
    }
    public WebElement getTrashBin() {
        return driver.findElement(trashBin);
    }
    public void clickLogout() {
        getLogout().click();
    }
    public void clickGoToStore() {
        getGoToStoreButton().click();
    }
    public void clickDeleteAllBooks() {
        getDeleteAllBooks().click();
    }
    public void clickDeleteAccount() {
        getDeleteAccount().click();
    }
    public void clickModalOk() {
        getModalOk().click();
    }
    public void clickModalCancel() {
        getModalCancel().click();
    }
    public void clickTrashBin() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getTrashBin()).click().perform();
    }
}
