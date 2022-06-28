package tests;

import basic.BasePage;
import bookStoreApp.*;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookStoreAppTest extends BasePage {

    public void login() throws InterruptedException {
        goToBookStoreApp();
        setHeight();
        pageDown();
        Thread.sleep(2000);
        bookStoreAppPage.clickLoginOption();
        scrollDown20();
        loginBS.sendUserNameBookStore("Prepelica");
        loginBS.sendPasswordBookStore("Qwer123!");
        loginBS.clickLoginButton();
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.navigate().to(homePage);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void beforeTest() {
        wdm = new ChromeDriverManager();
        wdm.setup();
        driver = new ChromeDriver();
        wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
        bookStoreAppPage = new BookStoreAppPage(driver);
        loginBS = new LoginBS(driver);
        bookStore = new BookStore(driver);
        profile = new Profile(driver);
        bookStoreAPI = new BookStoreAPI(driver);
    }

    @Test
    public void executeLoginToBSNewUser() throws InterruptedException {
        goToBookStoreApp();
        setHeight();
        pageDown();
        Thread.sleep(1000);
        bookStoreAppPage.clickLoginOption();
        loginBS.clickNewUserButton();
        scrollDown200();
        Thread.sleep(1000);
        loginBS.sendFirstNameR("Prepe");
        loginBS.sendLastNameR("Lica");
        loginBS.sendUserNameR("Prepelica");
        loginBS.sendPasswordR("Qwer123!");
    }
    @Test
    public void executeBookStoreLoginLogout() throws  InterruptedException {
        goToBookStoreApp();
        setHeight();
        pageDown();
        Thread.sleep(2000);
        bookStoreAppPage.clickLoginOption();
        loginBS.sendUserNameBookStore("Prepelica");
        loginBS.sendPasswordBookStore("Qwer123!");
        loginBS.clickLoginButton();
        Thread.sleep(2000);
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

        profile.clickLogout();
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }
    @Test
    public void loginGoToStore() throws InterruptedException {
        login();
        Thread.sleep(2000);
        pageDown();
        wdw.until(ExpectedConditions.elementToBeClickable(profile.getGoToStoreButton()));
        profile.clickGoToStore();
        Thread.sleep(2000);
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }
    @Test
    public void LoginDeleteAccount() throws InterruptedException {
        goToBookStoreApp();
        setHeight();
        pageDown();
        Thread.sleep(2000);
        bookStoreAppPage.clickLoginOption();
        loginBS.sendUserNameBookStore("Prepelica");
        loginBS.sendPasswordBookStore("Qwer123!");
        loginBS.clickLoginButton();
        Thread.sleep(2000);
        pageDown();
        wdw.until(ExpectedConditions.elementToBeClickable(profile.getDeleteAccount()));
        profile.clickDeleteAccount();
        profile.clickModalOk();
        driver.switchTo().alert().accept();

    }
    @Test
    public void LoginDeleteAllBooks() throws InterruptedException {
        goToBookStoreApp();
        setHeight();
        pageDown();
        Thread.sleep(2000);
        bookStoreAppPage.clickLoginOption();
        loginBS.sendUserNameBookStore("Prepelica");
        loginBS.sendPasswordBookStore("Qwer123!");
        loginBS.clickLoginButton();
        Thread.sleep(2000);
        pageDown();
        wdw.until(ExpectedConditions.elementToBeClickable(profile.getDeleteAllBooks()));
        profile.clickDeleteAllBooks();
        profile.clickModalOk();
        driver.switchTo().alert().accept();
    }
    @Test
    public void bookStoreAPItoSwagger() throws InterruptedException {
        goToBookStoreApp();
        setHeight();
        pageDown();
        Thread.sleep(2000);
        bookStoreAppPage.clickBookStoreAPI();
        Thread.sleep(5000);
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/swagger/");
    }
    @Test
    public void readBookDescBackToLibrary() throws InterruptedException {
        goToBookStoreApp();
        //bookStore.selectSpecificBook("Speaking JavaScript");
        pageDown();
        bookStore.clickBackToBookStore();
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }
    @Test
    public void addBook() throws InterruptedException {
        login();
        Thread.sleep(2000);
        pageDown();
        wdw.until(ExpectedConditions.elementToBeClickable(profile.getGoToStoreButton()));
        profile.getGoToStoreButton().click();
        Thread.sleep(2000);
        bookStore.selectBookTitle("Git Pocket Guide");
        pageDown();
        wdw.until(ExpectedConditions.elementToBeClickable(bookStore.getAddToYourCollection()));
        bookStore.clickAddToYourCollection();
        driver.switchTo().alert().accept();
    }
    @Test
    public void deleteBook() throws InterruptedException {
        login();
        Thread.sleep(2000);
        scrollDown20();
        List<WebElement> rows = profile.getRows();
        int initialRowNr = rows.size();
        scrollDown100();
        wdw.until(ExpectedConditions.elementToBeClickable(profile.getTrashBin()));
        profile.clickTrashBin();
        profile.clickModalOk();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        List<WebElement> rows1 = profile.getRows();
        int newRowNr = rows1.size();

        assertTrue(initialRowNr == newRowNr + 1);

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
