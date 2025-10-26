import java.util.Scanner;
public class AloLoginSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] users = new String[100][2];
        int userCount = 0;
        int choice;

        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String loginUser = sc.nextLine();

                System.out.print("Enter password: ");
                String loginPass = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < userCount; i++) {
                    if (users[i][0].equals(loginUser) && users[i][1].equals(loginPass)) {
                        System.out.println("Hello, " + loginUser + "!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid username or password!");
                }
                System.out.println();

            } else if (choice == 2) {
                System.out.print("Enter new username: ");
                String newUser = sc.nextLine();

                boolean exists = false;
                for (int i = 0; i < userCount; i++) {
                    if (users[i][0].equals(newUser)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Username already exists!");
                    System.out.println();
                } else {
                    System.out.print("Enter password: ");
                    String newPass = sc.nextLine();

                    System.out.print("Confirm password: ");
                    String confirmPass = sc.nextLine();

                    if (!newPass.equals(confirmPass)) {
                        System.out.println("Passwords do not match!");
                        System.out.println();
                    } else {
                        users[userCount][0] = newUser;
                        users[userCount][1] = newPass;
                        userCount++;
                        System.out.println("Registration successful!");
                        System.out.println();
                    }
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option!");
                System.out.println();
            }
        }

        sc.close();
    }
}