package pglp.dao;

import pglp.formes.Cercle;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

import static java.sql.JDBCType.BLOB;


public class CercleDao extends Dao<Cercle> {

  public CercleDao(){

  }
  public byte[] toByte(Cercle cercle) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(cercle);
    ObjectInputStream objectIn = null;
    objectIn = new ObjectInputStream(new ByteArrayInputStream( out.toByteArray()));
    System.out.println(objectIn.readObject());
    return null;

  }



  @Override
  Cercle get(String nom) throws SQLException, IOException, ClassNotFoundException {
    Cercle cercle = null;
    psSelect = conn
        .prepareStatement(SQL_DESERIALIZE_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();

    // Object object = rs.getObject(1);

    byte[] buf = rs.getBytes("objet");
    ObjectInputStream objectIn = null;
    if (buf != null)
      objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
    //cercle = (Cercle)
    System.out.println(buf);
    rs.close();
    psSelect.close();
    return cercle;
  }


  @Override
  List<Cercle> getAll() {
    return null;
  }

  @Override
  void create(Cercle cercle) throws SQLException, IOException, ClassNotFoundException {

    psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
    statements.add(psInsert);
    //Object obj = (Object) cercle;
    psInsert.setString(1, cercle.getIdentifiant());
    psInsert.setBytes(2, this.toByte(cercle) );
    psInsert.setString(3,cercle.toString());
    psInsert.executeUpdate();
    System.out.println(this.toByte(cercle));
    }



  @Override
  void update(Cercle cercle, String[] params) {

  }

  @Override
  void delete(Cercle cercle) {

  }
}
