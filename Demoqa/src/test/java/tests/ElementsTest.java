package tests;

import basic.BasePage;
import elements.*;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ElementsTest extends BasePage {

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(homePage);
        driver.manage().window().maximize();
        goToElementsPage();
    }

    @BeforeTest
    public void beforeTest() {
        wdm = new ChromeDriverManager();
        wdm.setup();
        driver = new ChromeDriver();
        wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
        textBox = new TextBox(driver);
        checkBox = new CheckBox(driver);
        radioButton = new RadioButton(driver);
        elementsPage = new ElementsPage(driver);
        buttons = new Buttons(driver);
        links = new Links(driver);
        brokenLinksImages = new BrokenLinksImages(driver);
        uploadDownload = new UploadDownload(driver);
        dynamicProperties = new DynamicProperties(driver);
        webTables = new WebTables(driver);
    }

    @Test
    public void fillOutTextBox() throws InterruptedException {
        elementsPage.goToTextBox();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(By.id("submit"));
        String button1 = String.valueOf(button.getLocation().y - 400);
        Thread.sleep(2000);
        textBox.inputTextBox();

        assertTrue(textBox.getOutput().isDisplayed());
    }
    @Test
    public void tickCheckBoxHome() throws InterruptedException {
        elementsPage.goToCheckBox();
        Thread.sleep(3000);
        checkBox.clickHomeToggle();
        WebElement result = driver.findElement(By.id("result"));
        assertTrue(result.isDisplayed());
    }
    @Test
    public void clickOfficeBox() throws InterruptedException {
        elementsPage.goToCheckBox();
        Thread.sleep(3000);
        checkBox.getArrowDown().click();
        checkBox.getDoxToggle().click();
        checkBox.getOfficeBox().click();
        scrollDown100();
        assertEquals(checkBox.getResult().getText(), "You have selected :\n" + "office\n" +
                "public\n" + "private\n" + "classified\n" + "general");
    }
    @Test
    public void executePlus() {
        elementsPage.goToCheckBox();
        checkBox.clickPlus();
        assertTrue(checkBox.getMinus().isEnabled());
    }
    @Test
    public void activateYesRadioButton() {
        elementsPage.goToRadioButton();
        radioButton.clickYesButton();

        assertTrue(radioButton.getYesButton().isSelected());
        assertEquals(radioButton.getMessage().getText(), "Yes" );
    }
    @Test
    public void activateImpressiveRadioButton() {
        elementsPage.goToRadioButton();
        radioButton.clickImpressiveButton();

        assertTrue(radioButton.getImpressiveButton().isSelected());
        assertEquals(radioButton.getMessage().getText(), "Impressive" );
    }
    @Test
    public void activateNoRadioButton() {
        elementsPage.goToRadioButton();
        radioButton.clickNoButton();

        Assert.assertFalse(radioButton.getNoButton().isEnabled());
    }
    @Test
    public void webTablesFormInput(){
        scrollDown20();
        elementsPage.goToWebTables();
        webTables.clickAdd();
        wdw.until(ExpectedConditions.elementToBeClickable(webTables.getFirstName()));
        webTables.fillOutForm();
        webTables.getRows();
        WebElement newRow = webTables.getRow(3);
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/webtables");
        assertTrue(newRow.isDisplayed());
    }
    @Test
    public void deleteWebTableRow() {
        scrollDown20();
        elementsPage.goToWebTables();
        assertTrue(isRowNumberLowerAfterRowDeletedWT(2));
    }
    @Test
    public void activateDoubleClick() throws InterruptedException {
        Thread.sleep(1000);
        buttons.executeDoubleClick();
        assertTrue(buttons.getDoubleClickMessage().isDisplayed());
    }
    @Test
    public void activateRightClick() throws InterruptedException {
        Thread.sleep(1000);
        buttons.executeRightClick();
        assertTrue(buttons.getRightClickMessage().isDisplayed());
    }
    @Test
    public void activateDynamicClick() throws InterruptedException {
        Thread.sleep(1000);
        buttons.executeDynamicClick();
        assertTrue(buttons.getClickMeMessage().isDisplayed());
    }
    @Test
    public void goToHomeLink() throws InterruptedException {
        elementsPage.goToLinks();
        links.goToHomeLink();
        collectUrlTabPositionOne();
        assertEquals(driver.getCurrentUrl(),homePage);
    }
    @Test
    public void goToHomeLinkDynamic() throws InterruptedException {
        elementsPage.goToLinks();
        links.goToHomeLinkDynamic();
        collectUrlTabPositionOne();
        assertEquals(driver.getCurrentUrl(), homePage);
    }
    @Test
    public void activateCreatedAPI() {
        elementsPage.goToLinks();
        links.clickCreatedAPI();
        assertTrue(links.getResponse().isDisplayed());
        assertEquals(links.getResponse().getText(), "Link has responded with staus 201 and status text Created");

    }
    @Test
    public void activateBadRequestAPI() {
        elementsPage.goToLinks();
        links.clickBadRequestAPI();
        assertTrue(links.getResponse().isDisplayed());
        assertEquals(links.getResponse().getText(), "Link has responded with staus 400 and status text Bad Request");
    }
    @Test
    public void activateNotFoundAPI() {
        elementsPage.goToLinks();
        links.clickNotFoundAPI();
        assertTrue(links.getResponse().isDisplayed());
        assertEquals(links.getResponse().getText(), "Link has responded with staus 404 and status text Not Found");

    }
    @Test
    public void clickValidLink() {
        pageDown();
        elementsPage.goToBrokenLinksImages();
        brokenLinksImages.clickValidLink();
        assertEquals(driver.getCurrentUrl(), homePage);
    }
    @Test
    public void clickBrokenLink() {
        pageDown();
        elementsPage.goToBrokenLinksImages();
        brokenLinksImages.clickBrokenLink();
        assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/status_codes/500");
    }
    @Test
    public void checkValidImage() {
        Boolean isItDisplayed = (Boolean) js.executeScript
                ("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" "
                + "&& arguments[0].naturalWidth > 0", brokenLinksImages.getValidImage());
        assertTrue(isItDisplayed);
    }
    @Test
    public void checkBrokenImage() {
        Boolean isItDisplayed = (Boolean) js.executeScript
                ("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" "
                        + "&& arguments[0].naturalWidth > 0", brokenLinksImages.getBrokenImage());
        assertFalse(isItDisplayed);
    }
    @Test
    public void clickDownload() {
        pageDown();
        elementsPage.goToUploadDownload();
        uploadDownload.clickDownload();
        assertTrue(uploadDownload.getDownload().isSelected());
    }
    @Test
    public void uploadImage(){
        scrollDown200();
        elementsPage.goToUploadDownload();
        uploadDownload.uploadImage("C:\\Users\\Srdjan\\Desktop\\sample.jpg");
        assertTrue(uploadDownload.getUploadPath().isDisplayed());
    }
    @Test
    public void testEnableAfter5Button() throws InterruptedException {
        pageDown();
        wdw.until(ExpectedConditions.elementToBeClickable(elementsPage.getDynamicProperties()));
        elementsPage.goToDynamicProperties();
        double st = System.currentTimeMillis();
        wdw.until(ExpectedConditions.elementToBeClickable(dynamicProperties.getEnableAfter5()));
        double ft = System.currentTimeMillis();
        dynamicProperties.clickEnableAfter5();
        double waitTime = ft -st;

        assertTrue(dynamicProperties.getVisibleAfter5().isEnabled());
        assertTrue(waitTime > 5000);
    }
    @Test
    public void testVisibleAfter5() throws InterruptedException {
        scrollDown100();
        wdw.until(ExpectedConditions.elementToBeClickable(elementsPage.getDynamicProperties()));
        elementsPage.goToDynamicProperties();
        double st = System.currentTimeMillis();
        setWindowSize();
        wdw.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
        dynamicProperties.clickVisibleAfter5();
        double ft = System.currentTimeMillis();
        double waitTime = ft -st;

        assertTrue(dynamicProperties.getVisibleAfter5().isEnabled());
        assertTrue(waitTime > 5000);
    }
    @Test
    public void testColorChange() throws InterruptedException {
        scrollDown100();
        wdw.until(ExpectedConditions.elementToBeClickable(elementsPage.getDynamicProperties()));
        elementsPage.goToDynamicProperties();
        wdw.until(ExpectedConditions.visibilityOf(dynamicProperties.getColorChange()));
        dynamicProperties.clickColorChange();
        String initialColor = driver.findElement(By.id("colorChange")).getCssValue("color");
        Thread.sleep(5000);
        String newColor = driver.findElement(By.id("colorChange")).getCssValue("color");
        assertNotEquals(newColor, initialColor);
        assertEquals(newColor, "rgba(220, 53, 69, 1)");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
