package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WebTables {
    WebDriver driver;
    By add = By.id("addNewRecordButton");
    By searchBox = By.id("searchBox");
    By clickSearch = By.id("basic-addon2");
    By row = By.className("rt-tr-group");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");
    //By edit = By.id("")

    public WebTables(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getAdd() {
        return driver.findElement(add);
    }
    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }
    public WebElement getClickSearch() {
        return driver.findElement(clickSearch);
    }
    public List<WebElement> getRows(){
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
    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }
    public WebElement getLastName() {
        return driver.findElement(lastName);
    }
    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getAge() {
        return driver.findElement(age);
    }
    public WebElement getSalary() {
        return driver.findElement(salary);
    }
    public WebElement getDepartment() {
        return driver.findElement(department);
    }
    public WebElement getSubmit() {
        return driver.findElement(submit);
    }
    public void clickAdd() {
        getAdd().click();
    }
    public void sendSearchBox(String target) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getSearchBox()).click().sendKeys(target).sendKeys(Keys.ENTER).perform();
    }
    public void activateClickSearch(){
        getClickSearch().click();
    }
    public void sendFirstName(String fn) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getFirstName()).click().sendKeys(fn).perform();
    }
    public void sendLastName(String ln) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getLastName()).click().sendKeys(ln).perform();
    }
    public void sendEmail(String email) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getEmail()).click().sendKeys(email).perform();
    }
    public void sendAge(String age) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getAge()).click().sendKeys(age).perform();
    }
    public void sendSalary(String s) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getSalary()).click().sendKeys(s).perform();
    }
    public void sendDepartment(String dept) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDepartment()).click().sendKeys(dept).perform();
    }
    public void clickSubmit() {
        getSubmit().click();
    }

    public void clearFirstName(){
        getFirstName().clear();
    }
    public void clearLastName(){
        getLastName().clear();
    }
    public void clearEmail(){
        getEmail().clear();
    }
    public void clearAge(){
        getAge().clear();
    }
    public void clearSalary(){
        getSalary().clear();
    }
    public void clearDepartment(){
        getDepartment().clear();
    }
    public void fillOutForm() {
        sendFirstName("Iva");
        sendLastName("Na");
        sendEmail("some@thing.me");
        sendAge("37");
        sendSalary("99000");
        sendDepartment("Future");
        clickSubmit();
    }
    public void deleteRow(int i){
        driver.findElement(By.id(String.format("delete-record-%d", i + 1))).click();
    }


}
