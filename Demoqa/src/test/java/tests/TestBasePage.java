package tests;

import basic.BasePage;
import bookStoreApp.BookStoreAppPage;
import bookStoreApp.LoginBS;
import elements.*;
import forms.PracticeFormOption;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestBasePage extends BasePage {
    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(homePage);
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
        practiceForm = new PracticeFormOption(driver);
        elementsPage = new ElementsPage(driver);
        buttons = new Buttons(driver);
        bookStoreAppPage = new BookStoreAppPage(driver);
        loginBS = new LoginBS(driver);
    }

    @Test
    public void goToElementsURL() {
        goToElementsPage();
        assertEquals(driver.getCurrentUrl(), homePage);
    }
    @Test
    public void goToFormsURL() {
        goToFormPage();
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/forms");
    }
    @Test
    public void gotoBookStoreAppPageURL() throws InterruptedException {
        goToBookStoreApp();
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }
    @Test
    public void logoButtonToHome() {
        driver.findElement(By.cssSelector("header img"));
        assertEquals(driver.getCurrentUrl(), homePage);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
