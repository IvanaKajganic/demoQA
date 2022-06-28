package tests;

import basic.BasePage;
import elements.*;
import forms.PracticeFormOption;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormsTest extends BasePage {
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
        practiceForm = new PracticeFormOption(driver);
        elementsPage = new ElementsPage(driver);
    }

    @Test
    public void fillOutPracticeForm() throws InterruptedException {
        goToFormPage();
        driver.manage().window().maximize();
        practiceForm.clickPracticeFormButton();
        setHeight();
        practiceForm.sendFirstName("Iva");
        practiceForm.sendLastName("Na");
        practiceForm.sendEmail("some@thing.me");
        practiceForm.clickGender(1);
        practiceForm.sendMobileNumber("0123456789");
        practiceForm.sendBirthDate("08 Sep 1985");
        scrollDown200();
        practiceForm.sendSubject("Hindi");
        Thread.sleep(100);
        practiceForm.pickHobby(1);
        practiceForm.uploadPicture("C:\\Users\\Srdjan\\Desktop\\sample.jpg");
        scrollDown200();
        Thread.sleep(100);
        practiceForm.sendCurrentAddress("Vlajkoviceva 17");
        driver.findElement(By.id("currentAddress")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(100);
        practiceForm.pickState("u");
        practiceForm.pickCity("a");
        practiceForm.clickSubmit();

        assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());

        //practiceForm.clickCloseModal();
        //assertEquals(driver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
