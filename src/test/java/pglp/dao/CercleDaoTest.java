package pglp.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pglp.InitBdd;
import pglp.formes.Cercle;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CercleDaoTest {

  private static Cercle c1;
  static Dao<Cercle> dao;

  @BeforeClass
  public static void init(){
    System.out.println("1");
    Dao.conn = InitBdd.getConn();

    c1 = new Cercle("c1",2,4,6);
    dao = DaoFactory.getDaoCercle();
  }



  @Test
  public void testCreate() throws SQLException, IOException, ClassNotFoundException {
    dao.create(c1);
  }

  @Test
  public void testGet() throws IOException, SQLException, ClassNotFoundException {
    Cercle c = dao.get("c1");
  }


}