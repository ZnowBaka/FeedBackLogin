import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] username = {"admin", "user1", "user2"};
        String[] password = {"password123", "letmein", "qwerty"};
        int maxTry = 3;
        boolean loggedIn = false;
        System.out.println("Login required...");
        loggedIn = loggingInUsername(input, username, password, maxTry, loggedIn);

        if (loggedIn) {
            System.out.println("you have been logged in...");
        } else {
            System.out.println("please try again later");
        }
        System.exit(0);

    }

    public static boolean loggingInUsername(Scanner input, String[] username, String[] password, int maxTry, boolean loggedIn) {
        System.out.println("loggin in..." + "\n" + "Plase enter username");
        int index;
        boolean accepted = false;
        while (!accepted) {

            String inputUsername = input.next();

            for (int i = 0; i < username.length; i++) {
                if (username[i].equals(inputUsername)) {
                    index = i;
                    System.out.println("please enter password...");
                    accepted = true;
                    loggedIn = loggingInPassword(input, password, maxTry, loggedIn, index);

                }
            }


        }
        return loggedIn;
    }

    public static boolean loggingInPassword(Scanner input, String[] password, int maxTry, boolean loggedIn, int index) {


        for (int i = 0; i < maxTry; i++) {
            String inputPassword = input.next();
            if (password[index].equals(inputPassword)) {
                System.out.println("1");
                i = 100;
                loggedIn = true;
            } else if (i == maxTry){
                System.out.println("you have used all your tries");
            } else {
                System.out.println("try again");
            }

        }


        return loggedIn;
    }
}