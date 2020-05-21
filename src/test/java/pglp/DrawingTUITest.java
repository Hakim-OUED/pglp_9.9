package pglp;

import org.junit.BeforeClass;
import org.junit.Test;
import pglp.commandes.Commande;
import pglp.dao.Dao;
import pglp.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DrawingTUITest {
private static DrawingTUI drawingTUI;
@BeforeClass
public static void init(){
  drawingTUI = new DrawingTUI();
}
  @Test
  public void testNextCommand() throws IOException, UnknowCommandException, ClassNotFoundException, UnknowFormException, KeyAlreadyExistException, SQLException, DrawingNotExistException, UnloadedDrawingException, DrawingAlreadyLoadException {
    Dao.conn = InitBdd.getConn();
    Commande cmd = drawingTUI.nextCommand("show(c1)");
    String result = cmd.execute();
    //System.out.println(result);
  }
}