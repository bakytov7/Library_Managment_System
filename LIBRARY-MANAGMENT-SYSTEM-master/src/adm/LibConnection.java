package ke.org.adm;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class LibConnection {


// libconnection class constructor

    public LibConnection(){

    }

    public void  getConnection() {

        Connection connection ;

        try {
            String db = "jdbc:mysql://localhost:3306/libraryinfo";
            String username = "root";
            String password = "";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, username, password);
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
