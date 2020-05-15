package ke.org.adm;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static java.lang.Class.forName;

public class ViewLibrarian {



    public ViewLibrarian(){


    }

    //method to view the librarian details
   public  void viewLibrarian() throws SQLException, ClassNotFoundException {
       Connection connection;
       String db = "jdbc:mysql://localhost:3306/libraryinfo";
       String username = "root";
       String passwordD = "";
       forName("com.mysql.jdbc.Driver");
       connection = DriverManager.getConnection(db, username, passwordD);
       PreparedStatement preparedstatement;
       String sql = "SELECT * FROM  librarianinfo";
       preparedstatement = connection.prepareStatement(sql);


       ResultSet rs = null;

       try {
           rs = preparedstatement.executeQuery();
           while (rs.next()) {
               String one=(rs.getString("FIRSTNAME"));
               String JJ=(rs.getString("LASTNAME"));
              String Mn=(rs.getString("IDNO"));
              String bb=(rs.getString("PHONENUMBER"));
               String nn=(rs.getString("EMAIL"));



               System.out.println(one +""+JJ +""+Mn +""+bb +"" +nn);
Scanner scanner=new Scanner(System.in);
               System.out.println("DO YOU WANT TO ADD ANOTHER ACTION?  (YES OR NO");
               String respons=scanner.next();

               if(respons.equals("YES")){
                   Admin ad= new Admin();
                   ad.adminDashboard();

               }
               else {
                  LibLogin LL=new LibLogin();
                  LL.getLogin();

               }
           }


       } catch (Exception e) {

           e.printStackTrace();
       }


   }




}
