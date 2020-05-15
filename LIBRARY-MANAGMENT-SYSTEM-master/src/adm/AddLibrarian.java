package ke.org.adm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class AddLibrarian {

    String firstname;
    String lastname;
    String idno;
    String contact;
    String email;
    String password;

    Connection connection;


    public AddLibrarian(){


    }



    public void register(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER FIRST NAME    :");
        String firstname=scanner.next();
        System.out.println("ENTER LAST NAME    :");
        String lastname=scanner.next();
        System.out.println("ENTER LIBRARIAN ID NUMBER  :");
        String idno= scanner.next();
        System.out.println("ENTER PHONE NUMBER    :");
        String contact=scanner.next();
        System.out.println("ENTER EMAIL ADDRESS    :");
        String email=scanner.next();
        System.out.println("ENTER PASSWORD(use last four contact numbers + first letters in firstname and lastname");
        String password=scanner.next();

        //System.out.println(firstname);

        if(firstname.isEmpty()|| lastname.isEmpty()|| idno.isEmpty() || contact.isEmpty() || email.isEmpty() || password.isEmpty()){

            System.out.println("ENTER ALL THE DETAILS ");
        }
        else{
            //used to insert data to the database1

            //import connection class
            LibConnection LL=new LibConnection();
                LL.getConnection();


            //creating the sql statement
            try {

                String db = "jdbc:mysql://localhost:3306/libraryinfo";
                String username = "root";
                String passwordD = "";
                forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(db, username, passwordD);
                PreparedStatement preparedstatement;

                String sql;
                sql="insert  into librarianinfo (FIRSTNAME,LASTNAME,IDNO,EMAIL,PHONENUMBER,PASSWORD) VALUES ('"+firstname+"','"+lastname+"','"+idno+"','"+email+"','"+contact+"','"+password+"')";
                preparedstatement=connection.prepareStatement(sql);

                preparedstatement.executeUpdate();

                System.out.println("YOU HAVE SUCCESFULLY ADDED A LIBRARIAN");

//querying for adding another detail
                System.out.println("DO YOU WANT TO ADD ANOTHER LIBRARIAN?  (YES OR NO)");
                String respons=scanner.next();

                if(respons.equals("YES")){
                    register();

                }
                else {
                    Admin ad=new Admin();
                    ad.adminDashboard();

                }
            }
            catch (SQLException e){

                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }


    }
}
