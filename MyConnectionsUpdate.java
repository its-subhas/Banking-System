import java.sql.*;

public class MyConnectionsUpdate {

    protected static boolean checkUpdate(long useraadhaarNumber, int newPin, int pin) {

        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";
        boolean updated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            if (updatePin(con, useraadhaarNumber, newPin, pin)) {
                updated = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updated;
    }


    protected static boolean updatePin(Connection con, long useraadhaarNumber, int newPin, int pin) {
        boolean updated = false;

        try {
            String query = "update registration set pin = ? where aadhaar = ? and pin = ?;";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setInt(1, newPin);
            pre.setLong(2, useraadhaarNumber);
            pre.setInt(3, pin);
            int update = pre.executeUpdate();

            if (update > 0) {
                updated = true;
                System.out.println("Updated Successfully !");
                System.out.println();
                System.out.println();
            } else {
                System.out.println("Wrong Pin !");
            }
            pre.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updated;
    }


}
