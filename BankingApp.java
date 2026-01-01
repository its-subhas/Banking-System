public class BankingApp {

    public static void main(String[] args) {

        Register.register(); // Login and Register Function.

    }
}



/*   DATABASE SCHEMA

PLEASE MAKE SURE REPLACE CREDENTIALS WITH REAL ONE IN SOURCE FILES.

        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";



 TABLE NAME - REGISTRATION
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| aadhaar  | bigint      | NO   | PRI | NULL    |       |
| name     | varchar(50) | NO   |     | NULL    |       |
| dob      | varchar(15) | NO   |     | NULL    |       |
| phone    | bigint      | NO   |     | NULL    |       |
| email    | varchar(30) | NO   |     | NULL    |       |
| password | varchar(15) | NO   |     | NULL    |       |
| pin      | int         | NO   |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+



 TABLE NAME - ACCOUNT
+----------+--------+------+-----+---------+----------------+
| Field    | Type   | Null | Key | Default | Extra          |
+----------+--------+------+-----+---------+----------------+
| id       | int    | NO   | PRI | NULL    | auto_increment |
| aadhaar  | bigint | NO   |     | NULL    |                |
| accountn | bigint | NO   |     | NULL    |                |
| balance  | bigint | YES  |     | 500     |                |
+----------+--------+------+-----+---------+----------------+


*/
