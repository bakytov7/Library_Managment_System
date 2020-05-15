package ke.org.adm;

import java.sql.SQLException;
import java.util.Scanner;

public class Librarian {

    public Librarian(){




    }

    //ADMIN DASHBOARD
    public void libDashboard() throws SQLException, ClassNotFoundException {

        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER THE ACTION YOU WISH TO PERFORM :");
        System.out.println( "\n ENTER VALUE 1 TO DO ADD BOOK :" +
                "\n ENTER VALUE 2 TO VIEW BOOKS DETAILS : "+
                "\n ENTER VALUE 3 TO ISSUE BOOKS  : "+
                "\n ENTER VALUE 4 TO VIEW ISSUED BOOKS  : "+
                "\n ENTER VALUE 5 TO RETURN BOOKS   :  "+
                "\n ENTER VALUE 6 TO LOG OUT   :");
        int librarianrole=scanner.nextInt();
//LIBRARIAN ROLES
        //ADD book
        if(librarianrole==1){
            System.out.println("YOU ARE ADDING A NEW BOOK");
            AddBooks ab=new AddBooks();
            ab.addBook();
        }

        //VIEW BOOKS
        else if (librarianrole==2){
            System.out.println("VIEW BOOKS DETAILS HERE");
ViewBooks vb=new ViewBooks();
            try {
                vb.viewBooks();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //ISSUE BOOKS
        else if (librarianrole==3){
            System.out.println("YOU HAVE SELECTED TO ISSUE BOOKS");
IssueBook IS=new IssueBook();
IS.getConnection();
        }
        //VIEW ISSUED BOOKS
        else if (librarianrole==4){
            System.out.println("VIEWING ISSUED BOOKS DETAILS HERE");
         ViewIssuedbooks vv=new ViewIssuedbooks();
           vv.viewIsbooks();

        }

        //RETURN BOOK
        else if (librarianrole==5){
            System.out.println("YOU HAVE SELECTED TO RETURN BOOKS");
            ReturnBook rt=new ReturnBook();
            rt.getBookid();

        }

        //LOG OUT
        else if (librarianrole==6){
            System.out.println("WELCOME NEXT TIME");
            System.out.println("YOU HAVE SUCCEESFULLY LOG OUT");

            LibLogin mm=new LibLogin();
            mm.getLogin();

        }
        else {

            System.exit(0);
        }

    }
}
