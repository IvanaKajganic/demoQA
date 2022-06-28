package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {
    public WebDriver driver;

    By userNameField = By.id("userName");
    By emailField = By.id("userEmail");
    By currAddressField = By.id("currentAddress");
    By permAddressField = By.id("permanentAddress");
    By submitButtonField = By.id("submit");
    By output = By.id("output");

    private String userName = "Iva Na";
    private String email = "some@thing.me";
    private String currAdd = "Makedonska 15";
    private String permAdd = "Vojvodjanska 3";

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUserNameField() {
        return driver.findElement(userNameField);
    }
    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }
    public WebElement getCurrAddressField() {
        return driver.findElement(currAddressField);
    }
    public WebElement getPermAddressField() {
        return driver.findElement(permAddressField);
    }
    public WebElement getSubmitButtonField() {
        return driver.findElement(submitButtonField);
    }
    public WebElement getOutput () {
        return driver.findElement(output);
    }
    public void inputTextBox() {
        getUserNameField().sendKeys(userName);
        getEmailField().sendKeys(email);
        getCurrAddressField().sendKeys(currAdd);
        getPermAddressField().sendKeys(permAdd);
        getSubmitButtonField().click();
    }
}
