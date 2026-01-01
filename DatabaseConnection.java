import java.sql.*;

public class DatabaseConnection {
    protected static boolean databaseEntry(long aadhaarNumber, String fullName, String dob, long phoneNumber, String emailAddress, String loginPassword, int transactionPin) {

        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";
        boolean inserted = false;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);


            String query = "insert into registration (aadhaar,name,dob,phone,email,password,pin) values (?,?,?,?,?,?,?);";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setLong(1, aadhaarNumber);
            pre.setString(2, fullName);
            pre.setString(3, dob);
            pre.setLong(4, phoneNumber);
            pre.setString(5, emailAddress);
            pre.setString(6, loginPassword);
            pre.setInt(7, transactionPin);

            int insert = pre.executeUpdate();

            if (insert > 0) {

                String getAccount = "select accountn from account order by id desc limit 1;";
                PreparedStatement get = con.prepareStatement(getAccount);
                ResultSet rs = get.executeQuery();
                long myAccountNumber = 0;
                if (rs.next()) {
                    myAccountNumber = rs.getLong("accountn");
                    myAccountNumber = myAccountNumber + 7;
                    System.out.println("Your Account Number: " + myAccountNumber);
                } else {
                    System.out.println("Account Number Creation Failed !");
                }


                String accountCreation = "insert into account (aadhaar,accountn) values (?,?);";
                PreparedStatement account = con.prepareStatement(accountCreation);
                account.setLong(1, aadhaarNumber);
                account.setLong(2, myAccountNumber);

                int createAccount = account.executeUpdate();
                if (createAccount > 0) {
                    System.out.println("Account Created Successfully !");
                } else {
                    System.out.println("Account Creation Failed !");
                }

                inserted = true;

                account.close();
                get.close();
            }


            pre.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return inserted;

    }
}
