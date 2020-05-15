package ke.org.adm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddBooks {

    String bookname;
    String bookid;
    String bookauthor;
    String contact;
    String issueid;

    Connection connection;

    public AddBooks() {


    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIssueid() {
        return issueid;
    }

    public void setIssueid(String issueid) {
        this.issueid = issueid;
    }


    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER BOOK ID    :");
        String bookid = scanner.next();
        System.out.println("ENTER BOOK NAME    :");
        String bookname = scanner.next();
        System.out.println("ENTER BOOK AURTHOR NAME  :");
        String bookauthor = scanner.next();
        System.out.println("ENTER THE ISSUE ID TO THE BOOK   :");
        String issueid = scanner.next();


        if (bookauthor.isEmpty() || bookid.isEmpty() || bookname.isEmpty() || issueid.isEmpty()) {

            System.out.println("ENTER ALL THE DETAILS ");
            addBook();
        } else {
            //used to insert data to the database1

            //import connection class
            LibConnection LL = new LibConnection();


            PreparedStatement preparedstatement;

            //creating the sql statement
            try {

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryinfo", "root", "");
                String sql;
                sql = "insert  into books (BOOKID,BOOKAUTHOR,BOOKTITLE,ISSUEID) VALUES ('" + bookid + "','" + bookname + "','" + bookauthor + "','" + issueid + "')";
                preparedstatement = connection.prepareStatement(sql);

                preparedstatement.executeUpdate();

                System.out.println("YOU HAVE SUCCESFULLY ADDED A BOOK");


                System.out.println("DO YOU WANT TO ADD ANOTHER BOOK?  (YES OR NO)");
                String response=scanner.next();

                if(response.equals("YES")){
                    addBook();

                }
                else {
                    Librarian ll=new Librarian();
                    ll.libDashboard();

                }

            } catch (SQLException e) {

                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }


    }
}

