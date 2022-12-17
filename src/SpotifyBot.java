import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;


public class SpotifyBot {
    private WebDriver driver;
    private WebDriverWait wait;

    public SpotifyBot(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait= wait;
    }


        public boolean login(String username, String password, boolean rememberLogin) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chrome\\chromedriver.exe");
        driver.get("https://open.spotify.com/");
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[data-testid='login-button']")));
        WebElement loginBtn= driver.findElement(By.cssSelector("button[data-testid='login-button']"));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-username")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-password")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-button")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("label[for='login-remember'] > span")));

        WebElement userNameTxt= driver.findElement(By.id("login-username"));
        WebElement userPasswordTxt= driver.findElement(By.id("login-password"));
        userNameTxt.sendKeys(username);
        userPasswordTxt.sendKeys(password);
        WebElement rememberCheckbox= driver.findElement(By.cssSelector("label[for='login-remember']> span"));  // what is needed to be clicked to change the checkbox value
        WebElement rememberCheckboxElem= driver.findElement(By.id("login-remember"));  //the checkbox element itself
        if(rememberCheckboxElem.isSelected()==true && rememberLogin ==false){
            rememberCheckbox.click();
        }

        WebElement mainLoginBtn= driver.findElement(By.id("login-button"));
        mainLoginBtn.click();
        Thread.sleep(4500);

        try {
            WebElement loginError= driver.findElement(By.className("Message-sc-15vkh7g-0"));
        }
        catch(NoSuchElementException  e){
            System.out.println("No Error");
            return true;
        }
            return false;


//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("jb9xD5ECTqKFK02qe3HZ")));
//        WebElement playlist= driver.findElement(By.className("jb9xD5ECTqKFK02qe3HZ"));
//        playlist.click();
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[data-testid='play-button']")));
//        WebElement playBtn= driver.findElement(By.cssSelector("button[data-testid='play-button']"));
//        playBtn.click();

    }

    public WebElement findSong(String searchQuery) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("search-icon")));
        WebElement searchBtn= driver.findElement(By.className("search-icon"));
        searchBtn.click();
        Thread.sleep(3500);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("QO9loc33XC50mMRUCIvf")));
        WebElement searchElem= driver.findElement(By.className("QO9loc33XC50mMRUCIvf"));
        searchElem.sendKeys(searchQuery);
        Thread.sleep(2000);
        WebElement result= driver.findElement(By.cssSelector("[data-testid='top-result-card']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(result).perform();

        return result;
    }


}
