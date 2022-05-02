package client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LmtTestClient {

    private RemoteWebDriver driver;
    public LmtTestClient() {
        try {
            driver = new ChromeDriver();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
            throw e1;
        }
    }
    public void openUrl(String url){
        driver.get(url);
    }
    public boolean titleMatch(String title){
        System.out.println(driver.getTitle());
        return title.matches(driver.getTitle());
    }

    public void clickOnLinkText(String link){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.linkText(link)));
        driver.findElement(By.linkText(link)).click();
    }
    public void closeCookies(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.cssSelector("body > section > div > div:nth-child(2) > div > div.action-buttons > button.btn.lmt-btn-type-primary.lmt-btn-color-black-1")));
        driver.findElement(By.cssSelector("body > section > div > div:nth-child(2) > div > div.action-buttons > button.btn.lmt-btn-type-primary.lmt-btn-color-black-1"))
                .click();
    }
    public void navigateBack(){
        driver.navigate().back();
    }
    public boolean linkIsVisible(String link) throws InterruptedException {

        return driver.findElement(By.linkText(link)).isDisplayed();
    }
    public void fillField(String fieldID,String value) throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.xpath("//*[@id='+fieldID+']")).sendKeys(value);
    }

    public void cleanup() {
        driver.manage().deleteAllCookies();
    }

    public void close() {
        driver.close();
    }
}
