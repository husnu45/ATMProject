import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName;
        String password;
        Scanner getData = new Scanner(System.in);
        int balance = 1000;
        int login_attempt = 3;

        while (true) {
            System.out.print("Enter Your Username: ");
            userName = getData.nextLine();
            System.out.print("Enter Your Password: ");
            password = getData.nextLine();

            if (userName.equals("husnu45") && password.equals("12345")) {
                System.out.println("Welcome to ATM");
                int select;

                do {
                    // Menüyü ekrana yazdırın
                    System.out.println("Choose Your Transaction: ");
                    System.out.println("Transaction Menu\n" +
                            "********************\n" +
                            "1. View Your Balance\n" +
                            "2. Deposit\n" +
                            "3. Withdraw\n" +
                            "4. Exit");
                    System.out.print("Choose the Transaction: ");

                    // Kullanıcının seçimini alın
                    select = getData.nextInt();

                    switch (select) {
                        case 1:
                            System.out.println("Your Balance is: " + balance);
                            break;
                        case 2:
                            System.out.print("Enter the Amount of Deposit: ");
                            int depositAmount = getData.nextInt();
                            balance += depositAmount;
                            System.out.println("Deposit Success!");
                            System.out.println("Your New Balance is " + balance);
                            break;
                        case 3:
                            System.out.print("Enter the Withdraw Amount: ");
                            int withdrawAmount = getData.nextInt();
                            if (withdrawAmount > balance) {
                                System.out.println("Insufficient Balance.");
                            } else {
                                balance -= withdrawAmount;
                                System.out.println("Withdraw Success!");
                                System.out.println("Your New Balance is: " + balance);
                            }
                            break;
                        case 4:
                            System.out.println("Thank you for visiting us. Have a nice day!");
                            break;
                        default:
                            System.out.println("Invalid Transaction...");
                            break;
                    }
                } while (select != 4);

                break;
            } else {
                login_attempt -= 1;
                System.out.println("Username or Password Incorrect. Please Try Again... Login Attempt Left: " + login_attempt);
                if (login_attempt == 0) {
                    System.out.println("Login Attempt Failed 3 Times in a row. Try Again Later.");
                    break;
                }
            }
        }
    }
}
