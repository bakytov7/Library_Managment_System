package ke.org.adm;

import java.sql.Connection;
import java.util.Scanner;

public class LibMain {

    public static  void main(String args[]){

        //connection for the database
       Connection con;

       //calling the connection class
       LibConnection lc= new LibConnection();
        lc.getConnection();
       //Scanner class
        Scanner scan=new Scanner(System.in);

        //Openning dashboard for a library system user to select the

    System.out.println("");

        System.out.println("LIBRARY MANAGMENT SYSTEM");
        System.out.println("");

        //select the role to do

        System.out.println(
                "\n ENTER VALUE 1 TO DO ADMIN ROLES  :" +
                "\n ENTER VALUE 2 TO DO LIBRARIAN ROLES ");
        int val=scan.nextInt();

        //checking the input to validate entered input
         if((val==1) || (val==2)) {

//LOGGING MODULE
           //call the liblogin class

             LibLogin Llogin=new LibLogin();
             Llogin.getLogin();


         }
         else {
             System.out.println("WRONG INPUTS,INPUT VALUE 1 OR 2");
             scan.close();
         }


         }


}
