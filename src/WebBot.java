import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBot {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println(driver.getTitle());
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("my-text-id")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("button")));

//        WebElement firstLabel= driver.findElement(By.tagName("label"));
//        WebElement textBox= driver.findElement(By.id("my-text-id"));   //finding by id
        WebElement textBox= driver.findElement(By.cssSelector("label > input"));  //can select via css selector as well
        WebElement btn= driver.findElement(By.tagName("button"));

        textBox.sendKeys("Hello world");
        Thread.sleep(2000);
        btn.click();
    }
}
