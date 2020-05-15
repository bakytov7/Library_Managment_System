package ke.org.adm;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class ViewIssuedbooks {



    public ViewIssuedbooks(){


    }

    //method to view details

    public void viewIsbooks() throws SQLException, ClassNotFoundException {

        Connection connection = null;
        String db = "jdbc:mysql://localhost:3306/libraryinfo";
        String username = "root";
        String passwordD = "";
        Class<?> aClass = forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(db, username, passwordD);
        PreparedStatement preparedstatement;




        String sql = "SELECT * FROM  booksinquiry";
        preparedstatement= connection.prepareStatement(sql);




        ResultSet rs = null;

        try {


            rs = preparedstatement.executeQuery();
            while (rs.next()) {
                System.out.println("ISSUED ID >>>>>>>>  ISSUED DATE>>>>>>   ISSUEDTO>>>>   BOOK ID");
                String mm = (rs.getString("ISSUEID"));
                String gg = (rs.getString("ISSUEDATE"));
                String hh = (rs.getString("ISSUEDTO"));
                String aa = (rs.getString("BOOKID"));

                System.out.println(mm + "" + gg + "" + hh + "" + aa);
            }

            Scanner scanner=new Scanner(System.in);
            System.out.println("ENTER THE BOOKS ID DISPLAYED ON THE TABLE ABOVE  :");
             String id = scanner.next();

             String vvv="select * from books where BOOKID='"+id+"'";
            PreparedStatement pr;
             pr=connection.prepareStatement(vvv);
            ResultSet rr=null;


            rr= preparedstatement.executeQuery();
            while (rr.next()) {
            System.out.println("BOOK ID >>>>>>>>  BOOK NAME>>>>>>   BOOK TITLE>>>>   ");
            String MM = (rs.getString("BOOKID"));
            String KK = (rs.getString("BOOKAUTHOR"));
            String JG = (rs.getString("BOOKTITLE"));

            System.out.println(MM + "" + KK + "" + JG );

        }

            } catch (Exception e) {

            e.printStackTrace();
        }

    }


}
