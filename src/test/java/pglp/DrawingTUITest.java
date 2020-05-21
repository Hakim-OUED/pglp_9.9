package pglp;

import org.junit.BeforeClass;
import org.junit.Test;

import pglp.dao.Dao;
import pglp.exceptions.*;
import java.io.IOException;
import java.sql.SQLException;

public class DrawingTUITest {
private static DrawingTUI drawingTUI;
@BeforeClass
public static void init(){
  drawingTUI = new DrawingTUI();
}
  @Test
  public void testNextCommand() throws IOException, UnknowCommandException, ClassNotFoundException, UnknowFormException, KeyAlreadyExistException, SQLException, DrawingNotExistException, UnloadedDrawingException, DrawingAlreadyLoadException {
    Dao.conn = InitBdd.getConn();
    //Commande cmd = drawingTUI.nextCommand("show(c1)");
    //String result = cmd.execute();
    //System.out.println(result);
  }
}