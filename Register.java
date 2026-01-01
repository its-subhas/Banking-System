import java.util.Scanner;

public class Register {

    protected static void register() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------");
            System.out.println("REGISTER OR LOGIN");
            System.out.println("------------------------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Choose an Option: ");
            int option = input.nextInt();
            if (option != 1 && option != 2 && option != 3) {
                System.out.println();
                System.out.println("Invalid Choice, Try Again !");
                System.out.println();
            } else if (option == 1) {
                register(input);
            } else if (option == 2) {
                login(input);
            } else {
                if (exit(input)) {
                    return;
                }
            }
        }
    }

    protected static void register(Scanner input) {
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("REGISTER ( Cancel --> 0)");
            System.out.println();
            System.out.print("Enter Aadhaar Number: ");
            long aadhaarNumber = input.nextLong();
            if (aadhaarNumber == 0) {
                System.out.println("Registration Cancelled !");
                System.out.println();
                System.out.println();
                break;
            }
            input.nextLine();
            System.out.print("Enter Full Name: ");
            String fullName = input.nextLine();
            if (fullName.equalsIgnoreCase("0")) {
                System.out.println("Registration Cancelled !");
                continue;
            }
            System.out.print("Enter DOB: ");
            String dob = input.nextLine();
            if (dob.equalsIgnoreCase("0")) {
                System.out.println("Registration Cancelled !");
                continue;
            }
            System.out.print("Enter Phone Number: +91 ");
            long phoneNumber = input.nextLong();
            if (phoneNumber == 0) {
                System.out.println("Registration Cancelled !");
                continue;
            }
            input.nextLine();
            System.out.print("Enter Email Address: ");
            String emailAddress = input.nextLine();
            if (emailAddress.equalsIgnoreCase("0")) {
                System.out.println("Registration Cancelled !");
                continue;
            }
            System.out.print("Set Login Password: ");
            String loginPassword = input.nextLine();
            if (loginPassword.equalsIgnoreCase("0")) {
                System.out.println("Registration Cancelled !");
                continue;
            }
            System.out.print("Set Transaction Pin: ");
            int transactionPin = input.nextInt();
            if (transactionPin == 0) {
                System.out.println("Registration Cancelled !");
                continue;
            }

            boolean inserted = DatabaseConnection.databaseEntry(aadhaarNumber, fullName, dob, phoneNumber, emailAddress, loginPassword, transactionPin);

            if (inserted) {
                System.out.println("Registration Completed Successfully !");
                System.out.println();
                System.out.println();
            } else {
                System.out.println("Registration Failed !");
                System.out.println();
                System.out.println();
            }

            break;
        }
    }

    protected static void login(Scanner input) {
        input.nextLine();
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("LOGIN ( Cancel --> 0 )");
            System.out.println();
            System.out.print("Enter Email Address: ");
            String emailAddress = input.nextLine();
            if (emailAddress.equalsIgnoreCase("0")) {
                System.out.println("Login Cancelled !");
                System.out.println();
                System.out.println();
                break;
            }
            System.out.print("Enter Login Password: ");
            String loginPassword = input.nextLine();
            if (loginPassword.equalsIgnoreCase("0")) {
                System.out.println("Login Cancelled !");
                continue;
            }
            System.out.print("Enter Aadhaar Number: ");
            long aadhaarNumber = input.nextLong();
            if (aadhaarNumber == 0) {
                input.nextLine();
                System.out.println("Login Cancelled !");
                continue;
            }
            input.nextLine();

            boolean login = UserLogin.login(input, emailAddress, loginPassword, aadhaarNumber);
            if (login) {
                System.out.println();
                System.out.println();
                break;
            }
        }
    }

    protected static boolean exit(Scanner input) {
        System.out.println();
        System.out.println();
        System.out.println("EXIT APP");
        while (true) {
            System.out.println();
            System.out.println("Want To Exit !");
            System.out.println("Exit: YES or NO");
            System.out.print("Enter: ");
            String exit = input.next();
            if (exit.equalsIgnoreCase("YES")) {
                System.out.println("Exit Successfully !");
                System.out.println();
                System.out.println();
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
