import java.sql.*;


public class MyConnections {

    protected static boolean check(long useraadhaar, int pin) {

        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";
        boolean fetch = false;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            long aadhaarVerify = balanceverify(con, useraadhaar, pin);
            if (aadhaarVerify == useraadhaar) {
                balance(con, useraadhaar);
                fetch = true;
            } else {
                System.out.println("Wrong Pin !");
            }


            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fetch;
    }


    protected static void balance(Connection con, long aadhaar) {


        try {
            String query = "select balance from account where aadhaar = ?;";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setLong(1, aadhaar);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                System.out.println("Account Balance: " + rs.getLong("balance"));
            } else {
                System.out.println("Something Went Wrong !");
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    protected static long balanceverify(Connection con, long useraadhaar, int pin) {

        long aadhaar = 0;

        try {
            String queryemail = "select email from registration where aadhaar = ?;";
            PreparedStatement preemail = con.prepareStatement(queryemail);
            preemail.setLong(1, useraadhaar);
            ResultSet rs = preemail.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");

                String query = "select aadhaar from registration where email = ? and pin = ?;";
                PreparedStatement pre = con.prepareStatement(query);
                pre.setString(1, email);
                pre.setInt(2, pin);

                ResultSet rsv = pre.executeQuery();

                if (rsv.next()) {
                    aadhaar = rsv.getLong("aadhaar");
                }

                rsv.close();
                pre.close();
            }


            rs.close();
            preemail.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aadhaar;
    }

}
