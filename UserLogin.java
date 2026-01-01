import java.sql.*;
import java.util.Scanner;


public class UserLogin {

    protected static boolean login(Scanner input, String emailAddress, String loginPassword, long aadhaarNumber) {


        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";
        boolean loginSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select name from registration where email = ? and password = ? and aadhaar = ?;";

            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, emailAddress);
            pre.setString(2, loginPassword);
            pre.setLong(3, aadhaarNumber);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                loginSuccess = true;
                System.out.println("Login Successfully !");
                System.out.println();
                System.out.println();
                System.out.println("Welcome: " + rs.getString("name"));
                System.out.println();
                UserInterface.interfaceuser(aadhaarNumber);
            } else {
                System.out.println("Login Failed !");
            }

            pre.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loginSuccess;
    }

}
