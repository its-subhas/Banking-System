import java.sql.*;
import java.util.Scanner;

public class TransactionMoney {


    protected static void accountDetails(long useraadhaarNumber, long amount, long receiveAccount) {
        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";
        Scanner input = new Scanner(System.in);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            String withdrawquery = "update account set balance = balance - ? where aadhaar = ? and balance >= ?;";
            String depositquery = "update account set balance = balance + ? where accountn = ?;";

            PreparedStatement withdraw = con.prepareStatement(withdrawquery);
            withdraw.setLong(1, amount);
            withdraw.setLong(2, useraadhaarNumber);
            withdraw.setLong(3, amount);

            int sendCheck = withdraw.executeUpdate();

            if (sendCheck > 0) {

                PreparedStatement deposit = con.prepareStatement(depositquery);
                deposit.setLong(1, amount);
                deposit.setLong(2, receiveAccount);
                int depositCheck = deposit.executeUpdate();

                if (depositCheck > 0) {
                    getNameReceiver(con, receiveAccount);
                    if (pinVerifySender(input, con, useraadhaarNumber)) {
                        con.commit();
                        System.out.println("Transaction Completed Successfully !");
                    } else {
                        con.rollback();
                        System.out.println("Transaction Failed !");
                    }
                } else {
                    con.rollback();
                    System.out.println("Transaction Failed !");
                }

                deposit.close();

            } else {
                con.rollback();
                System.out.println("Transaction Failed !");
            }


            withdraw.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getNameReceiver(Connection con, long receiveAccount) {

        try {
            String query = "select aadhaar from account where accountn = ?";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setLong(1, receiveAccount);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                long aadhaar = rs.getLong("aadhaar");

                String sql = "select name from registration where aadhaar = ?";
                PreparedStatement preName = con.prepareStatement(sql);
                preName.setLong(1, aadhaar);
                ResultSet rsName = preName.executeQuery();

                if (rsName.next()) {
                    System.out.println("Receiver Name: " + rsName.getString("name"));
                }

                rsName.close();
                preName.close();
            }

            rs.close();
            pre.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    protected static boolean pinVerifySender(Scanner input, Connection con, long useraadhaarNumber) {

        System.out.print("Enter Pin: ");
        int pin = input.nextInt();
        int verify = 0;

        try {
            String query = "select pin from registration where aadhaar = ? limit 1;";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setLong(1, useraadhaarNumber);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                verify = rs.getInt("pin");
            } else {
                verify = -1;
            }


            rs.close();
            pre.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (pin == verify) {
            return true;
        } else {
            return false;
        }
    }

}
