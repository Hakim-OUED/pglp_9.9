package pglp.commandes;

import org.junit.BeforeClass;
import org.junit.Test;
import pglp.InitBdd;
import pglp.dao.Dao;
import pglp.exceptions.DrawingNotExistException;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.exceptions.UnknowFormException;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CmdShowTest {
  private static CmdShow cmd;

  @BeforeClass
  public static void init() {
    Dao.conn = InitBdd.getConn();
    cmd = new CmdShow("c1");
  }
  @Test
  public void testExecute() throws DrawingNotExistException, IOException, KeyAlreadyExistException, SQLException, UnknowFormException, ClassNotFoundException {
    String result = cmd.execute();
    String expected = "identifiant= c1--> " +
        "Cercle(centre=(X:2, Y:4),rayon=6)";
    assertEquals(result,expected);
  }
}