package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {
    WebDriver driver;
    By homeLink = By.id("simpleLink");
    By dynamicHomeLink = By.id("dynamicLink");
    By createdAPI = By.id("created");
    By noContentAPI = By.id("no-content");
    By movedAPI = By.id("moved");
    By badRequestAPI = By.id("bad-request");
    By unauthorizedAPI = By.id("unauthorized");
    By forbiddenAPI = By.id("forbidden");
    By notFoundAPI = By.id("invalid-url");
    By response = By.id("linkResponse");


    public Links(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getHomeLink() {
        return driver.findElement(homeLink);
    }
    public WebElement getDynamicHomeLink() {
        return driver.findElement(dynamicHomeLink);
    }
    public WebElement getCreatedAPI() {
        return driver.findElement(createdAPI);
    }
    public WebElement getNoContentAPI() {
        return driver.findElement(noContentAPI);
    }
    public WebElement getMovedAPI() {
        return driver.findElement(movedAPI);
    }
    public WebElement getBadRequestAPI() {
        return driver.findElement(badRequestAPI);
    }
    public WebElement getUnauthorizedAPI() {
        return driver.findElement(unauthorizedAPI);
    }
    public WebElement getForbiddenAPI() {
        return driver.findElement(forbiddenAPI);
    }
    public WebElement getNotFoundAPI() {
        return driver.findElement(notFoundAPI);
    }
    public WebElement getResponse() {
        return driver.findElement(response);
    }
    public void goToHomeLink() {
        getHomeLink().click();
    }
    public void goToHomeLinkDynamic() {
        getDynamicHomeLink().click();
    }
    public void clickCreatedAPI() {
        getCreatedAPI().click();
    }
    public void clickNoContentAPI() {
        getNoContentAPI().click();
    }
    public void clickMovedAPI() {
        getMovedAPI().click();
    }
    public void clickBadRequestAPI() {
        getBadRequestAPI().click();
    }
    public void clickUnauthorizedAPI() {
        getUnauthorizedAPI().click();
    }
    public void clickForbiddenAPI() {
        getForbiddenAPI().click();
    }
    public void clickNotFoundAPI() {
        getNotFoundAPI().click();
    }
}
