package pglp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public abstract class InitBdd {

  static String nomBd;
  static Connection conn = null;
  static ArrayList<Statement> statements = new ArrayList<Statement>();
  static Statement s;



  public static Connection getConn(){
    Properties props = new Properties(); // connection properties
    props.put("user", "user");
    props.put("password", "user");
    nomBd = "dessins";
    try {
      conn = DriverManager.getConnection("jdbc:derby:" + nomBd
          + ";create=true", props);
      s = conn.createStatement();
      statements.add(s);
      s.execute("create table dessin(id varchar(20), objet CHAR(254) FOR BIT DATA, description varchar(100))");


      //s.execute("drop table dessin");

    } catch (SQLException e) {
      System.out.println("Erreur de connexion à la BD");
      e.printStackTrace();
    }
    return conn;
  }

}
