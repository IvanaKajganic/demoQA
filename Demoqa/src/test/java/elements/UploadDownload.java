package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadDownload {
    WebDriver driver;
    By download = By.id("downloadButton");
    By upload = By.id("uploadFile");
    By uploadPath = By.id("uploadedFilePath");

    public UploadDownload(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getDownload() {
        return driver.findElement(download);
    }
    public WebElement getUpload() {
        return driver.findElement(upload);
    }
    public WebElement getUploadPath() {
        return driver.findElement(uploadPath);
    }
    public void clickDownload() {
        getDownload().click();
    }
    public void uploadImage(String path) {
        driver.findElement(upload).sendKeys(path);
    }
}
