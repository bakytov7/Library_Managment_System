package ke.org.adm;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin {

    public Admin(){




    }

    public void adminDashboard(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER THE ACTION YOU WISH TO PERFORM :");
        System.out.println( "\n ENTER VALUE 1 TO DO ADD LIBRARIAN :" +
                "\n ENTER VALUE 2 TO VIEW LIBRARIAN DETAILS : "+
                "\n ENTER VALUE 3 TO DELETE A LIBRARIAN DETAILS  : "+
                "\n ENTER VALUE 4 TO LOG OUT");
        int adminrole=scanner.nextInt();

        //ADMIN ROLES


        if(adminrole==1){
            System.out.println("YOU HAVE SELECTED TO ADD A NEW LIBRARIAN DETAILS");
            AddLibrarian adb=new AddLibrarian();
            adb.register();

        }


        //VIEW LIBRARIAN
        else if (adminrole==2){
            System.out.println(" YOU HAVE SELECTED TO VIEW LIBRARIAN DETAILS ");
            ViewLibrarian vl=new ViewLibrarian();
            try {
                vl.viewLibrarian();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //DELETE LIBRARIAN
        else if (adminrole==3) {
            System.out.println("YOU HAVE SELECTED TO DELETE A LIBRARIAN");
DeleteLibrarian dl=new DeleteLibrarian();
            try {
                dl.getIdnumber();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //LOG OUT
        else if (adminrole==4){
            System.out.println("WELCOME NEXT TIME");
            System.out.println("YOU HAVE SUCCEESFULLY LOG OUT");
            LibLogin NN=new LibLogin();
            NN.getLogin();
        }
        //wrong input on the role
        else{
            System.out.println("INVALID INPUT,INPUT VALUE 1 OR 2 OR 3 OR 4");
            adminDashboard();
        }
    }






}
