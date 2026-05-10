package database;

import java.sql.*;

import database.secret;

/**
 *@author Flower
 *
 *
 */
public class SQLconnect {
  /**
   *Does the interaction between the program and the database
   */
  Connection conn = get_connection();

  public static void main(String[] args){
    secret secret = new secret();

  }
  
  private static Connection get_connection(){
    /**
     *Creates a connection to the existing database
     *
     */ 

    String database_password = secret.get_password();

    try{
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", database_password);

      conn.setAutoCommit(false);
      return conn;
    }catch(SQLException e){
      System.out.println("An error has occured connecting to the database");
      return null;
    }
  }
  
  private boolean do_match(String username, String password){
    /**
     *Checks the database for a matching set of given credentials
     *@return boolean
     *
     *
     */ 

    ResultSet rs = null;

    try{
      String query = " Select * from users where username = ? and password = ?;";

      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, username);
      st.setString(2, password);

      rs = st.executeQuery();

      if(rs.next() == true){
        return true; //it was found one row with set
      } else {
        return false;
      }
    }catch(SQLException e){
      System.out.println("An error has occured: " + e);
      return false;
    }
  }

}
