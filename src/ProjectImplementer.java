import java.util.Scanner;

public class ProjectImplementer {

    public static void main(String args[]){
        System.out.println("Enter Username: ");
        Scanner usernameScanner= new Scanner(System.in);
        System.out.println("Enter Password: ");
        Scanner passwordScanner= new Scanner(System.in);
        String username= usernameScanner.next();
        String password= passwordScanner.next();
        SpotifyBot bot1= new SpotifyBot(username,password);
        try {
            bot1.automate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
