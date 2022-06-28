package bookStoreApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginBS {
    WebDriver driver;
    By userNameField = By.id("userName");
    By passwordField = By.id("password");
    By loginButton = By.id("login");
    By newUserButton = By.id("newUser");
    By firstNameRegister = By.id("firstname");
    By lastNameRegister = By.id("lastname");
    By userNameRegister = By.id("userName");
    By passwordRegister = By.id("password");
    By registerButtonR = By.id("register");
    By backToLogin = By.id("gotologin");

    public LoginBS(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserNameField() {
        return driver.findElement(userNameField);
    }
    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }
    public WebElement getNewUserButton() {
        return driver.findElement(newUserButton);
    }
    public WebElement getFirstNameRegister() {
        return driver.findElement(firstNameRegister);
    }
    public WebElement getLastNameRegister() {
        return driver.findElement(lastNameRegister);
    }
    public WebElement getUserNameRegister() {
        return driver.findElement(userNameRegister);
    }
    public WebElement getPasswordRegister() {
        return driver.findElement(passwordRegister);
    }
    public WebElement getRegisterButtonR() {
        return driver.findElement(registerButtonR);
    }
    public WebElement getBackToLoginButton() {
        return driver.findElement(backToLogin);
    }
    public void sendUserNameBookStore(String un) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getUserNameField()).click().sendKeys(un).build().perform();
    }
    public void sendPasswordBookStore(String pw) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getPasswordField()).click().sendKeys(pw).perform();
    }
    public void clickLoginButton() {
        getLoginButton().click();
    }
    public void clickNewUserButton() {
        getNewUserButton().click();
    }
    public void sendFirstNameR(String fn) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getFirstNameRegister()).click().sendKeys(fn).perform();
    }
    public void sendLastNameR(String ln) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getLastNameRegister()).click().sendKeys(ln).perform();
    }
    public void sendUserNameR(String un) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getUserNameRegister()).click().sendKeys(un).perform();
    }
    public void sendPasswordR(String un) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getPasswordRegister()).click().sendKeys(un).perform();
    }
    public void clickRegisterButtonR(){
        getRegisterButtonR().click();
    }
    public void clickBackToLogin() {
        getBackToLoginButton().click();
    }
}
