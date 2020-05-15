package ke.org.adm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class ReturnBook {

    String bookid;
    String status;

    Connection connection;
    Scanner scanner = new Scanner(System.in);

    public ReturnBook() {


    }

    public String getBookid() throws SQLException, ClassNotFoundException {


        //INPUT THE PASSWORD TO LOG IN AS EITHER ADMIN OR LIBRARIAN
        System.out.println("ENTER THE RETURN ID:");
        String id = scanner.next();
        System.out.println("ENTER THE DATE IT IS RETURNED :");
        String DT = scanner.next();
        System.out.println("ENTER THE YES/NO FOR RETURNED BOOK  :");
        String status = scanner.next();
        System.out.println("ENTER THE BOOK ID  :");
        String bd = scanner.next();

        if (id.isEmpty() || status.isEmpty()) {
            System.out.println("FILL ALL THE DETAILS PLEASE:");
            getBookid();

        } else {
            LibConnection lb=new LibConnection();
            lb.getConnection();

            //statement to return book

            try{
                String db = "jdbc:mysql://localhost:3306/libraryinfo";
                String username = "root";
                String passwordD = "";
                forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(db, username, passwordD);
                PreparedStatement preparedstatement;

                String sql;
                sql="insert  into bookreturn (RETURNID,RETURNDATE,RETURNSTATUS,BOOKID) VALUES ('"+id+"','"+DT+"','"+status+"','"+bd+"')";
                preparedstatement=connection.prepareStatement(sql);

                preparedstatement.executeUpdate();



        System.out.println("THEBOOK HAS BEEN SUCEESSFULLY RETURNED");

                System.out.println("DO YOU WANT TO RETURN ANOTHER BOOK?  (YES OR NO)");
                String responss=scanner.next();

                if(responss.equals("YES")){
                    getBookid();

                }
                else {
                  Librarian kk=new Librarian();
                  kk.libDashboard();

                }

            }

            catch (Exception e){


                e.printStackTrace();
            }


            System.out.println("BOOK HAS BEEN RETURNED SUCCESFULLY");

            System.out.println("DO YOU WANT TO RETURN ANOTHER BOOK?  (YES OR NO)");
            String responss = scanner.next();

            if (responss.equals("YES")) {
                getBookid();

            } else {
                Librarian ad = new Librarian();
                ad.libDashboard();


            }
        }
            return null;
        }


    }

