import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;


public class SpotifyBot {
    private String username;
    private String password;
    private String searchQuery;
    private Boolean rememberLogin;

    public SpotifyBot(String username, String password, String searchQuery,boolean rememberLogin){
        this.username=username;
        this.password=password;
        this.searchQuery= searchQuery;
        this.rememberLogin= rememberLogin;
    }
    public SpotifyBot(String username, String password){
        this(username, password, " ", false);
    }

    public SpotifyBot(String username, String password, boolean rememberLogin) {
        this(username, password, " ", rememberLogin);
    }


        public boolean login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://open.spotify.com/");
        System.out.println(driver.getTitle());
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[data-testid='login-button']")));
        WebElement loginBtn= driver.findElement(By.cssSelector("button[data-testid='login-button']"));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-username")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-password")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-button")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("label[for='login-remember'] > span")));

        WebElement userNameTxt= driver.findElement(By.id("login-username"));
        WebElement userPasswordTxt= driver.findElement(By.id("login-password"));
        userNameTxt.sendKeys(this.username);
        userPasswordTxt.sendKeys(this.password);
        WebElement rememberCheckbox= driver.findElement(By.cssSelector("label[for='login-remember']> span"));  // what is needed to be clicked to change the checkbox value
        WebElement rememberCheckboxElem= driver.findElement(By.id("login-remember"));  //the checkbox element itself
        if(rememberCheckboxElem.isSelected()==true && this.rememberLogin.equals(false)){
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

    public void findSong(){

    }


}
