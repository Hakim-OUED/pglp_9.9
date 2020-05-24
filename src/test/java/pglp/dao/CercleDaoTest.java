package pglp.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pglp.InitBdd;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.formes.Cercle;
import pglp.formes.Forme;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class CercleDaoTest {

  private static Cercle c1;
  static Dao<Cercle> dao;

  @BeforeClass
  public static void init() throws SQLException {
   /* Properties props = new Properties(); // connection properties
    props.put("user", "user");
    props.put("password", "user");
    Connection conn = DriverManager.getConnection("jdbc:derby:dessins", props);*/
    //Dao.conn = InitBdd.getConn();
    //InitBdd.createTables();

    c1 = new Cercle("c1",2,4,6);
    //dao = DaoFactory.getDaoCercle();

  }



  @Test
  public void testCreate() throws SQLException, IOException, ClassNotFoundException, KeyAlreadyExistException {
    //dao.create(c1);
  }

  @Test
  public void testGet() throws IOException, SQLException, ClassNotFoundException {
    //Cercle c = (Cercle) dao.get("c1");
    //System.out.println(c.getClass().getSimpleName());
  }


  @Test
  public void testUpdate() throws IOException, SQLException, ClassNotFoundException {
    c1 = new Cercle("c3",2,1,4);
    //dao.update(c1);
    //dao.get("c3");

  }

  @Test
  public void testDelete() {

  }
}