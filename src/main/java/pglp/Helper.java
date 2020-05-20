package pglp;

import java.sql.SQLException;

public class Helper {

  public static boolean tableExist(SQLException e) {
    boolean exist;
    if(e.getSQLState().equals("X0Y32")) {
      exist = true;
    } else {
      exist = false;
    }
    return exist;
  }

  public static boolean keyExist(SQLException e) {
    boolean exist;
    if(e.getSQLState().equals("23505")) {
      exist = true;
    } else {
      exist = false;
    }
    return exist;
  }

}

