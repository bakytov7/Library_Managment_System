package ke.org.adm;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class ViewBooks {



    public ViewBooks(){


    }
//method to view book


    public void viewBooks() throws ClassNotFoundException, SQLException {

        Connection connection;
        String db = "jdbc:mysql://localhost:3306/libraryinfo";
        String username = "root";
        String passwordD = "";
        forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(db, username, passwordD);
        PreparedStatement preparedstatement;
        String sql = "SELECT * FROM  books";
        preparedstatement = connection.prepareStatement(sql);


        ResultSet rs = null;

        try {
            rs = preparedstatement.executeQuery();
            while (rs.next()) {
                String cc=(rs.getString("BOOKID"));
                String ba=(rs.getString("BOOKAUTHOR"));
                String br=(rs.getString("BOOKTITLE"));
                String rt=(rs.getString("RETURNSTATUS"));

                System.out.println(cc +""+ba +""+br +""+rt );
                Scanner scanner=new Scanner(System.in);
                System.out.println("DO YOU WANT TO ADD ANOTHER ACTION?  (YES OR NO");
                String respons=scanner.next();

                if(respons.equals("YES")){

                    Librarian ln=new Librarian();
                    ln.libDashboard();
                }
                else {
                    LibLogin nn=new LibLogin();
                    nn.getLogin();
                }

            }


        } catch (Exception e) {

            e.printStackTrace();
        }


    }


}
