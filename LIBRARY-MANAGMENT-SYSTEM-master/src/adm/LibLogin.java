package ke.org.adm;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class LibLogin {

    Scanner scanner = new Scanner(System.in);
    String pass;

    public LibLogin() {


    }

    public void getLogin() {
        //INPUT THE PASSWORD TO LOG IN AS EITHER ADMIN OR LIBRARIAN
        System.out.println("ENTER YOUR LOGGING PASSWORD  :");
        String password = scanner.next();
        if (password.isEmpty()) {
            System.out.println("ENTER YOUR PASSWORD TO LOG IN PLEASE");
            getLogin();
        } else if (password.equals("1234567890")) {
            System.out.println("WELCOME");
            System.out.println("SUCCEESFULLY LOGGED IN AS ADMIN");

            Admin adm = new Admin();
            adm.adminDashboard();
        } else {
// librarian logging in
            Connection connection;

            String query;
            LibConnection LC = new LibConnection();
            LC.getConnection();

            try {
                String db = "jdbc:mysql://localhost:3306/libraryinfo";
                String username = "root";
                String passwordD = "";
                forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(db, username, passwordD);
                PreparedStatement preparedstatement;
                query = "SELECT * FROM librarianinfo WHERE PASSWORD=?";
                preparedstatement = connection.prepareStatement(query);

preparedstatement.setString(1,password);
                ResultSet rs;
                rs = preparedstatement.executeQuery();

                if(rs.next()){

                    System.out.println("LOGIN SUCCESFULL");
                    Librarian lr=new Librarian();
                    lr.libDashboard();
                }

                else{

                    System.out.println("WRONG PASSWORD PLEASE");
                    getLogin();
                }


            } catch (Exception e) {

                e.printStackTrace();
            }

        }


    }
}



