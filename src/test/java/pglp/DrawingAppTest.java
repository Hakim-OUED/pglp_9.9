package pglp;

import org.junit.Test;
import pglp.dao.Dao;

import static org.junit.Assert.*;

public class DrawingAppTest {

  @Test
  public void run() {

      Dao.conn = InitBdd.getConn();
      //DESSIN.run();

  }
}