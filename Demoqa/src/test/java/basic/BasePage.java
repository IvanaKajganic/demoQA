package basic;

import bookStoreApp.*;
import elements.*;
import forms.PracticeFormOption;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    public final String homePage = "https://demoqa.com/";
    public WebDriverManager wdm;
    public WebDriver driver;
    public WebDriverWait wdw;
    public JavascriptExecutor js;
    public ElementsPage elementsPage;
    public TextBox textBox;
    public CheckBox checkBox;
    public RadioButton radioButton;
    public WebTables webTables;
    public Buttons buttons;
    public Links links;
    public BrokenLinksImages brokenLinksImages;
    public UploadDownload uploadDownload;
    public DynamicProperties dynamicProperties;
    public PracticeFormOption practiceForm;
    public BookStoreAppPage bookStoreAppPage;
    public LoginBS loginBS;
    public BookStore bookStore;
    public Profile profile;
    public BookStoreAPI bookStoreAPI;

    public void js() {
        js = (JavascriptExecutor) driver;
    }

    public void goToElementsPage() {
        pageDown();
        wdw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card:nth-child(1) svg")));
        driver.findElement(By.cssSelector(".card:nth-child(1) svg")).click();
    }
    public void goToFormPage() {
        pageDown();
        wdw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card:nth-child(2) svg")));
        driver.findElement(By.cssSelector(".card:nth-child(2) svg")).click();
        setWindowSize();
    }
    public void goToBookStoreApp() throws InterruptedException {
        pageDown();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector
                ("#app > div > div > div.home-body > div > div:nth-child(6) > div > div.card-up")).click();
    }


    public void setWindowSize() {
        Dimension newDimension = new Dimension(1920,1080);
        driver.manage().window().setSize(newDimension);
    }
    public void setHeight() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.querySelector('.body-height').style.height = '200vh'");
    }
    public void scrollDown200() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }
    public void scrollDown100() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
    }
    public void scrollDown20() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,20)");
    }

    public void zoomOut60() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='60%'");
    }

    public void pageDown() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
    }
    public void collectUrlTabPositionOne() throws InterruptedException {
        Set<String> tabs = driver.getWindowHandles();
        ArrayList<String> tabCollection = new ArrayList<>(tabs);
        Thread.sleep(2000);
        driver.switchTo().window(tabCollection.get(1));
    }

    public boolean isRowNumberLowerAfterRowDeletedWT(int row) {
        List<WebElement> rows = webTables.getRows();
        int initialRowNr = rows.size();
        webTables.deleteRow(row);
        List<WebElement> rows1 = webTables.getRows();
        int newRowNr = rows1.size();
        if (initialRowNr == newRowNr - 1) {
            return false;
        }
        return true;
    }

    public boolean isRowNumberLowerAfterRowDeletedProfile(int row) throws InterruptedException {
        List<WebElement> rows = webTables.getRows();
        int initialRowNr = rows.size();
        Thread.sleep(2000);
        profile.clickTrashBin();
        List<WebElement> rows1 = webTables.getRows();
        int newRowNr = rows1.size();
        if (initialRowNr == newRowNr - 1) {
            return false;
        }
        return true;
    }

}


