package forms;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class PracticeFormOption {

    public WebDriver driver;
    By practiceForm = By.cssSelector(".show .text");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By genderMale = By.id("gender-radio-1");
    By genderFemale = By.id("gender-radio-2");
    By genderOther = By.id("gender-radio-3");
    By userMobile = By.id("userNumber");
    By dateOfBirth = By.id("dateOfBirthInput");
    By subject = By.id("subjectsInput");
    By picture = By.id("uploadPicture");
    By hobbiesSport = By.id("hobbies-checkbox-1");
    By hobbiesReading = By.id("hobbies-checkbox-2");
    By hobbiesMusic = By.id("hobbies-checkbox-3");
    By currentAddress = By.id("currentAddress");
    By dropdownState = By.id("state");
    By dropdownCity = By.id("city");
    By submitButton = By.id("submit");
    By closeModalButton = By.id("closeLargeModal");


    public PracticeFormOption(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPracticeForm() {
        return driver.findElement(practiceForm);
    }
    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }
    public WebElement getLastName() {
        return driver.findElement(lastName);
    }
    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getGenderMale() {
        return driver.findElement(genderMale);
    }
    public WebElement getGenderFemale() {
        return driver.findElement(genderFemale);
    }
    public WebElement getGenderOther() {
        return driver.findElement(genderOther);
    }
    public WebElement getUserMobile() {
        return driver.findElement(userMobile);
    }
    public WebElement getSubject() {
        return driver.findElement(subject);
    }
    public WebElement getHobbiesSport() {
        return driver.findElement(hobbiesSport);
    }
    public WebElement getHobbiesReading() {
        return driver.findElement(hobbiesReading);
    }
    public WebElement getHobbiesMusic() {
        return driver.findElement(hobbiesMusic);
    }
    public WebElement getCurrentAddress() {
        return driver.findElement(currentAddress);
    }
    public WebElement getDropdownState() {
        return driver.findElement(dropdownState);
    }
    public WebElement getDropdownCity() {
        return driver.findElement(dropdownCity);
    }
    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }
    public void clickPracticeFormButton() {
        getPracticeForm().click();
    }
    public void sendFirstName(String fistNameInput) {
        getFirstName().sendKeys(fistNameInput);
    }
    public void sendLastName(String lastNameInput) {
        getLastName().sendKeys(lastNameInput);
    }
    public void sendEmail(String emailInput) {
        getEmail().sendKeys(emailInput);
    }
    public void clickGender(int n) {
            switch (n) {
                case 0:
                    Actions actions = new Actions(driver);
                    actions.moveToElement(getGenderMale()).click().perform();
                    break;
                case 1:
                    Actions actions1 = new Actions(driver);
                    actions1.moveToElement(getGenderFemale()).click().perform();
                    break;
                case 2:
                    Actions actions2 = new Actions(driver);
                    actions2.moveToElement(getGenderOther()).click().perform();
                    break;
            }
    }
    public void sendMobileNumber(String mobileNrInput) {
        getUserMobile().sendKeys(mobileNrInput);
    }
    public void sendBirthDate(String date)  {
        driver.findElement(dateOfBirth).sendKeys(Keys.chord(Keys.CONTROL, "a"),date,Keys.ENTER);
    }
    public void sendSubject(String s) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(getSubject()).click().sendKeys(s).sendKeys(Keys.ENTER).build().perform();
    }
    public void pickHobby(int n) {
        switch (n) {
            case 1:
                Actions actions = new Actions(driver);
                actions.moveToElement(getHobbiesSport()).click().perform();
                break;
            case 2:
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(getHobbiesReading()).click().perform();
                break;
            case 3:
                Actions actions2 = new Actions(driver);
                actions2.moveToElement(getHobbiesMusic()).click().perform();
        }
    }
    public void uploadPicture(String path) {
        driver.findElement(picture).sendKeys(path);
    }
    public void sendCurrentAddress(String a) {
        getCurrentAddress().sendKeys(a);
    }
    public void pickState(String state) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDropdownState()).click().sendKeys(state).sendKeys(Keys.ENTER).perform();
    }
    public void pickCity(String city) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDropdownCity()).click().sendKeys(city).sendKeys(Keys.ENTER).perform();
    }
    public void clickSubmit() {
        getSubmitButton().click();
    }
    public void clickCloseModal() {
        driver.findElement(closeModalButton).click();
    }

}
