import java.util.Scanner;

public class ProjectImplementer {

    public static void main(String args[]){
        boolean login=false;
        while(login==false) {
            System.out.println("Enter Username: ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.next();
            System.out.println("Enter Password: ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.next();
            SpotifyBot bot1 = new SpotifyBot(username, password);
            try {
                login= bot1.login();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(login==false){
                System.out.println("Login Credentials not recognized!");
            }
        }
    }

}
