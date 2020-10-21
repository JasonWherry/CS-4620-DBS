/****************************************************************/
/* GradeBook Application Main class (Section 5.6)               */
/* Needs grade1.java and grade2.java to be compiled             */
/* Chapter 5; Oracle Programming -- A Primer                    */
/*            by R. Sunderraman                                 */
/****************************************************************/

import java.io.*; 
import java.sql.*;

class Ambassador { 

  public static void main (String args []) 
      throws SQLException, IOException { 

    Ambassador a1 = new Ambassador();
    boolean done;
    char ch,ch1;
    byte num = 0;

    try {
      Class.forName ("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
        System.out.println ("Could not load the driver");
        return;
      }
    String user, pass;
    user = "jwherry";
    pass = "jw394191";

    //  The following line was modified by Prof. Marling to work on prime

    Connection conn = DriverManager.getConnection
       ("jdbc:oracle:thin:@deuce.cs.ohio.edu:1521:class", user, pass);

    done = false;
    do {
      a1.menu();
      System.out.print("Type in your option: ");
      System.out.flush();
      ch = (char) System.in.read();
      ch1 = (char) System.in.read();
      switch (ch) {
        case '1' : a1.displayTable(conn);
                   break;
        case '2' : a1.addAmbassador(conn);
                   break;
        case '3' : a1.modAmbassador(conn);
                   break;
        case '4' : a1.delAmbassador(conn);
                   break;
        case '5' : a1.report1(conn);
                   break;
        case '6' : a1.report2(conn);
                   break;
        case 'q' : done = true;
                   break;
        default  : System.out.println("Type in option again");
      }
    } while (!done);

    conn.close();
  } // main closed


  void displayTable(Connection conn) throws SQLException, IOException 
  {
    Statement stmt = conn.createStatement();
    String query = "SELECT * FROM Ambassador";

    try 
    {
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      System.out.println("Error while displaying 'Ambassador' table"); 
      while (e != null) 
      {
        System.out.println("Message : " + e.getMessage());
        e = e.getNextException();
      }
    }
          ResultSet rset = stmt.executeQuery(query);
          System.out.println("\nAmbassador");
          System.out.println("-----------");
          System.out.println("FName          LName             Email                Major                                    GradDate      Committee                   Deptartment");
          System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          while (rset.next()) {
            String one = String.format("%1$-15s", rset.getString(1));
            String two = String.format("%1$-18s", rset.getString(2));
            String three = String.format("%1$-21s", rset.getString(3));
            String four = String.format("%1$-41s", rset.getString(4));
            String five = rset.getString(5).substring(0, 10);
            String six = String.format("%1$-28s", rset.getString(6));
            String seven = String.format("%1$-50s", rset.getString(7));

            System.out.println(one + two + three + four + five + "    " + six + seven);
          }
  }


  void addAmbassador(Connection conn) throws SQLException, IOException 
  {
    Statement stmt = conn.createStatement();

    // attributes for the 'Ambassador' entity
    String fName = readEntry("First Name: ");
    String lName = readEntry("Last Name: ");
    String email = readEntry("OU Email: ");
    String major = readEntry("Major: ");
    String gradDate = readEntry("Grad. Date: ");
    String committee = readEntry("Committee: ");
    String department = readEntry("Deptartment: ");

    String query = "INSERT INTO Ambassador(first_name, last_name, email, major, graduation_date, comm_name, dept_name) VALUES('" 
                    + fName + "', '" + lName + "', '" + email + "', '" + major + "', TO_DATE('" + gradDate + "', 'YYYY-MM-DD'), '" 
                    + committee + "', '" + department + "')";

    try 
    {
      int nrows = stmt.executeUpdate(query);
    } catch (SQLException e) {
        System.out.println("Error while adding an Ambassador entry");
        while (e != null) 
        {
          System.out.println("Message : " + e.getMessage());
          e = e.getNextException();
        }
        return;
      }
    stmt.close();

    System.out.println("\nAdded a new Ambassador entry");
  }

  void modAmbassador(Connection conn) throws SQLException, IOException 
  {
    String orgEmail = readEntry("Ambassador's Email: ");
    //System.out.println(orgEmail);
    String target = "SELECT * FROM Ambassador WHERE email='" + orgEmail + "'";
    //first_name, last_name, email, major, graduation_date, comm_name, dept_name

    Statement stmt = conn.createStatement();
    ResultSet rset;
    //stmt.setString(1, orgEmail);

    try 
    {
      rset = stmt.executeQuery(target);
    } catch (SQLException e) {
        System.out.println("Error while modifying an Ambassador entry");
        while (e != null) 
        {
          System.out.println("Message : " + e.getMessage());
          e = e.getNextException();
        }
        return;
      }
      System.out.println("");
      if( rset.next() ) {
        System.out.println("Old Ambassador email: " + rset.getString(3));
        String fName = readEntry("First Name: ");
        String lName = readEntry("Last Name: ");
        String email = readEntry("OU Email: ");
        String major = readEntry("Major: ");
        String gradDate = readEntry("Grad. Date: ");
        String committee = readEntry("Committee: ");
        String department = readEntry("Deptartment: ");

        String query = "UPDATE Ambassador SET first_name='" + fName + "'," + "last_name='" + lName + "', " + "email='" + email
                       + "', " + "major='" + major + "', " + "graduation_date=TO_DATE('" + gradDate + "', 'YYYY-MM-DD')" + ", " 
                       + "comm_name='" + committee + "', dept_name='" + department + "' WHERE email='" + orgEmail + "'";


        try {
          stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error updating Ambassador entry");
            while (e != null) 
            {
              System.out.println("Message : " + e.getMessage());
              e = e.getNextException();
            }
            return;
          }

          System.out.println("\nAmbassador entry was succussfully changed");

      } // closing if bracket
      else 
      {
        System.out.println("Ambassador was not identified");
      }

      stmt.close();

  }

  void delAmbassador(Connection conn) throws SQLException, IOException 
  {
    String delEmail = readEntry("Enter email of Ambassador to be deleted: ");
    String target = "DELETE Ambassador WHERE email='" + delEmail + "'";

    Statement stmt = conn.createStatement();

    try 
    {
      int nrows = stmt.executeUpdate(target);
    } catch (SQLException e) {
        System.out.println("Could not delete Ambassador");
        while (e != null) {
          System.out.println("Message     : " + e.getMessage());
          e = e.getNextException();
        }
        //conn.rollback();
        return;
      }
      System.out.println("\nAmbassador removed succussfully");
      stmt.close();
  }

  void report1(Connection conn) throws SQLException, IOException 
  {
    String rep1 = "SELECT DISTINCT dname, dlocation, dchair, major FROM Department JOIN Ambassador ON Department.dname=dept_name";

    Statement stmt = conn.createStatement();

    ResultSet rset;
    try
    {
      rset = stmt.executeQuery(rep1);
    } catch (SQLException e) {
        System.out.println("Error");
        while(e != null) {
          System.out.println("message : " + e.getMessage());
          e = e.getNextException();
        }
        return;
      }
      System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------");
      System.out.println("| Name of every Department, the Department's office location, each Department's chair, and the corresponding major |");
      System.out.println("--------------------------------------------------------------------------------------------------------------------\n");
      while(rset.next())
      {
        String one = String.format("%1$-57s", rset.getString(1));
        String two = String.format("%1$-23s", rset.getString(2));
        String three = String.format("%1$-15s", rset.getString(3));
        String four = String.format("%1$-15s", rset.getString(4));
        System.out.println(one + two + three + four);
      }
    System.out.println("\n");
    stmt.close();  
  }

  void report2(Connection conn) throws SQLException, IOException 
  {
    String rep2 = "SELECT first_name, last_name, cname FROM Ambassador, Committee WHERE cname=comm_name AND dept_name='School of Electrical Engineering and Computer Science'";
    Statement stmt = conn.createStatement();

    ResultSet rset;
    try
    {
      rset = stmt.executeQuery(rep2);
    } catch (SQLException e) {
        System.out.println("Error");
        while(e != null) {
          System.out.println("message : " + e.getMessage());
          e = e.getNextException();
        }
        return;
      }
      System.out.println("\n\n---------------------------------------------------------------------------");
      System.out.println("| Name and committee of every Ambassador in the EE/CS Department |");
      System.out.println("----------------------------------------------------------------------------\n");
      while(rset.next())
      {
        String one = String.format("%1$-15s", rset.getString(1));
        String two = String.format("%1$-15s", rset.getString(2));
        String three = String.format("%1$-15s", rset.getString(3));
        System.out.println(one + two + three);
      }
    System.out.println("\n");
    stmt.close();  
  }


  //readEntry function -- to read input string
  static String readEntry(String prompt) {
     try {
       StringBuffer buffer = new StringBuffer();
       System.out.print(prompt);
       System.out.flush();
       int c = System.in.read();
       while(c != '\n' && c != -1) {
         buffer.append((char)c);
         c = System.in.read();
       }
       return buffer.toString().trim();
     } catch (IOException e) {
       return "";
       }
   }

  void menu()
  {

    System.out.println("\n\n ----------");
    System.out.println(" |  MENU  |");
    System.out.println(" ----------\n");
    System.out.println("(1) Display Ambassador table");
    System.out.println("(2) Add an Ambassador");
    System.out.println("(3) Modify an Ambassador");
    System.out.println("(4) Delete an Ambassador");
    System.out.println("(5) Display Report 1");
    System.out.println("(6) Display Report 2");
    System.out.println("(q) Quit\n");
  }

} // closing class bracket 


