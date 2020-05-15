package ke.org.adm;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class DeleteLibrarian {

String idnumber;


    public DeleteLibrarian(){


    }

Scanner scanner=new Scanner(System.in);
    Connection connection;



    public String getIdnumber() throws SQLException, ClassNotFoundException {


        System.out.println("ENTER THE LIBRARIAN ID TO DELETE  :");
        String idnumber = scanner.next();

        if(idnumber.isEmpty()){

            System.out.println("ENTER THE LIBRARIAN ID :");
            getIdnumber();
        }
        else{
LibConnection nn= new LibConnection();
nn.getConnection();
            //delete statement
            String sql;
            sql="DELETE FROM librarianinfo WHERE IDNO=?";
            Connection connection;
            String db = "jdbc:mysql://localhost:3306/libraryinfo";
            String username = "root";
            String passwordD = "";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, username, passwordD);
            PreparedStatement preparedstatement;

            preparedstatement = connection.prepareStatement(sql);

preparedstatement.setString(1,idnumber);



          preparedstatement.executeUpdate();

            System.out.println("LIBRARIAN DETAILS DELETED");






            System.out.println("THE LIBRARIAN DETAILS IS SUCEESFULLY DELETED");

            System.out.println("DO YOU WANT TO DELETE ANOTHER LIBRARIAN?  (YES OR NO)");
            String responss=scanner.next();

            if(responss.equals("YES")){
                getIdnumber();

            }
            else {
                Admin ad=new Admin();
                ad.adminDashboard();

            }

        }

        return null;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
}
