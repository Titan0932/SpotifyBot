import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class ProjectImplementer {

    public static void main(String args[]){
        boolean login=false;
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        SpotifyBot bot1;
        bot1 = new SpotifyBot(driver, wait);

        while(login==false) {
            System.out.println("Enter Username: ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.next();
            System.out.println("Enter Password: ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.next();
            try {
                login= bot1.login(username, password, false);

            } catch (Exception e) {
                e.printStackTrace();
            }
            if(login==false){
                System.out.println("Login Credentials not recognized!");
            }
        }
        System.out.println("Enter Search: ");
        Scanner searchScanner = new Scanner(System.in);
        String searchQuery = searchScanner.next();
        try{
            WebElement song= bot1.findSong(searchQuery);
//            WebElement song= bot1.findSong("something the beatles");
            bot1.playSong(song);
        }
        catch (Exception e){
            System.out.println("ERROR FINDING SONG");
            e.printStackTrace();
        }
    }

}
