import java.util.Scanner;

public class UserInterface {
    protected static void interfaceuser(long aadhaarNumber) {
        long useraadhaarNumber = aadhaarNumber;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("WELCOME TO BANKING SYSTEM");
            System.out.println("----------------------------");
            System.out.println("1. Transactions");
            System.out.println("2. Check Balance");
            System.out.println("3. Update Credentials");
            System.out.println("4. Exit Banking System");
            System.out.println();
            System.out.print("Choose an Option: ");
            int option = input.nextInt();
            if (option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.println();
                System.out.println("Invalid Choice, Try Again !");
                System.out.println();
            } else if (option == 1) {
                transactions(input, useraadhaarNumber);
            } else if (option == 2) {
                balance(input, useraadhaarNumber);
            } else if (option == 3) {
                update(input, useraadhaarNumber);
            } else {
                if (exit(input)) {
                    return;
                }
            }
        }
    }


    protected static void transactions(Scanner input, long useraadhaarNumber) {

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("TRANSACTIONS ( Cancel --> 0)");
            System.out.println();
            System.out.print("Enter Amount: ");
            long amount = input.nextLong();
            if (amount == 0) {
                System.out.println("Transaction Cancelled !");
                System.out.println();
                System.out.println();
                break;
            }

            System.out.print("Enter Receiver Account Number: ");
            long receiverAccountNumber = input.nextLong();
            if (receiverAccountNumber == 0) {
                System.out.println("Transaction Cancelled !");
                continue;
            }
            TransactionMoney.accountDetails(useraadhaarNumber, amount, receiverAccountNumber);
            System.out.println();
            System.out.println();
            break;
        }

    }

    protected static void balance(Scanner input, long useraadhaarNumber) {

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("CHECK BALANCE ( Cancel --> 0)");
            System.out.println();
            System.out.print("Enter Pin: ");
            int pin = input.nextInt();
            if (pin == 0) {
                System.out.println("Balance Check Cancelled !");
                System.out.println();
                System.out.println();
                break;
            }
            if (MyConnections.check(useraadhaarNumber, pin)) {
                System.out.println();
                System.out.println();
                break;
            }
        }
    }


    protected static void update(Scanner input, long useraadhaarNumber) {

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("UPDATE CREDENTIALS ( Cancel --> 0)");
            System.out.println();
            System.out.print("Enter Pin: ");
            int pin = input.nextInt();
            if (pin == 0) {
                System.out.println("Update Cancelled !");
                System.out.println();
                System.out.println();
                break;
            }
            System.out.print("Enter New Pin: ");
            int newPin = input.nextInt();
            if (newPin == 0) {
                System.out.println("Update Cancelled !");
                continue;
            }
            boolean check = MyConnectionsUpdate.checkUpdate(useraadhaarNumber, newPin, pin);
            if (check) {
                break;
            }
        }
    }

    protected static boolean exit(Scanner input) {
        System.out.println();
        System.out.println();
        System.out.println("EXIT BANKING SYSTEM");
        while (true) {
            System.out.println();
            System.out.println("Want To Exit !");
            System.out.println("Exit: YES or NO");
            System.out.print("Enter: ");
            String exit = input.next();
            if (exit.equalsIgnoreCase("YES")) {
                System.out.println("Exit Successfully !");
                return true;
            } else if (exit.equalsIgnoreCase("NO")) {
                System.out.println("Exit Cancelled !");
                System.out.println();
                System.out.println();
                break;
            } else {
                System.out.println();
                System.out.println("Invalid Choice, Try Again !");
            }
        }
        return false;
    }

}




