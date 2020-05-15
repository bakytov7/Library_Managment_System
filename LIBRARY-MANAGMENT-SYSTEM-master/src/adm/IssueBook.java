package ke.org.adm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class IssueBook {

    String issueid;
    String issuedate;
    String returndate;
    String issuedto;
    String bookid;


    Connection connection;

    public IssueBook(){


    }


    public String getIssueid() {
        return issueid;
    }

    public void setIssueid(String issueid) {
        this.issueid = issueid;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getIssuedto() {
        return issuedto;
    }

    public void setIssuedto(String issuedto) {
        this.issuedto = issuedto;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Connection getConnection() {

        //GETTING CONNECTION FROM THE CONNECTION CLASS
        LibConnection VB=new LibConnection();

        VB.getConnection();



        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER THE ISSUE ID    :");
        String issueid=scanner.next();
        System.out.println("THE ISSUED DATE OF THE BOOK    :");
        String issuedate=scanner.next();

        System.out.println("ENTER THE NAME OF WHO IS ISSUED WITH THE BOOK    :");
        String issuedto=scanner.next();
        System.out.println("ENTER THE BOOK ID    :");
        String bookid=scanner.next();



        if(issueid.isEmpty()|| issuedate.isEmpty()|| issuedto.isEmpty() || bookid.isEmpty() ){

            System.out.println("ENTER ALL THE DETAIL  ");
            getConnection();
        }
        else{
            //used to insert data to the database1



            PreparedStatement preparedstatement;

            //creating the sql statement
            try {
                String db = "jdbc:mysql://localhost:3306/libraryinfo";
                String username = "root";
                String passwordD = "";
                forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(db, username, passwordD);

                String sql;
                sql="insert  into booksinquiry (ISSUEID,ISSUEDATE,ISSUEDTO,BOOKID) VALUES ('"+issueid+"','"+issuedate+"','"+issuedto+"','"+bookid+"')";
                preparedstatement=connection.prepareStatement(sql);

                preparedstatement.executeUpdate();



                preparedstatement.executeUpdate();

                System.out.println("ISSUED SUCEESFUL");

//querying for adding another detail
                System.out.println("DO YOU WANT TO ISSUE ANOTHER BOOK?  (YES OR NO)");
                String respons=scanner.next();

                if(respons.equals("YES")){
                    getConnection();

                }
                else {
                  Librarian LK=new Librarian();
                  LK.libDashboard();

                }
            }
            catch (SQLException e){

                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
