package pglp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import pglp.commandes.Commande;
import pglp.dao.Dao;
import pglp.exceptions.*;

/**
 * Classse principale.
 */

public enum DrawingApp {

  DESSIN;

  /**
   * Execute le programme.
   *
   * @throws IOException Exception des saisies
   */
  public static void run() {

    try {
      Connection connection = InitBdd.getConn();
      Dao.conn = connection;
      InitBdd.createTables();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    DrawingTUI drawingTUI = new DrawingTUI();
    Commande cmd;
    System.out.println("******Logiciel de Dessin ********");
    while (true) {
      try {
        cmd = drawingTUI.nextCommand();
        String result = cmd.execute();
        System.out.println(result);
      } catch (UnknowCommandException
          | SQLException | DrawingAlreadyLoadException
          | KeyAlreadyExistException | UnloadedDrawingException
          | ClassNotFoundException | DrawingNotExistException
          | UnknowFormException | IOException e) {
        System.out.println(e.getMessage());
      }

    }
  }

  public static void main(final String[] args) throws ClassNotFoundException, SQLException {

    DESSIN.run();
  }
}
