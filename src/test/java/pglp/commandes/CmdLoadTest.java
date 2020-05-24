package pglp.commandes;

import org.junit.Before;
import org.junit.Test;
import pglp.InitBdd;
import pglp.dao.Dao;
import pglp.exceptions.*;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CmdLoadTest {
  private static CmdLoad cmd;
  @Before
  public void init(){
    //Dao.conn = InitBdd.getConn();
    //cmd = new CmdLoad("c1");
  }
  @Test
  public void execute() throws DrawingAlreadyLoadException, DrawingNotExistException, IOException, KeyAlreadyExistException, SQLException, UnloadedDrawingException, UnknowFormException, ClassNotFoundException {
    //String result = cmd.execute();
    //assertTrue(CmdCreate.formes.containsKey("c1"));
  }
}