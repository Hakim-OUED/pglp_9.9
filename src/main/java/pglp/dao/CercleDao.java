package pglp.dao;

import pglp.Helper;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.formes.Cercle;
import pglp.formes.Forme;

import java.io.*;
import java.sql.*;
import java.util.List;


public class CercleDao extends Dao<Cercle> {

  public CercleDao(){

  }

  @Override
  public Cercle getSpecific(String nom) throws SQLException, IOException, ClassNotFoundException {
    Cercle cercle = null;
    psSelect = conn
        .prepareStatement(SQL_DESERIALIZE_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();
    byte[] b = rs.getBytes(2);
    ByteArrayInputStream is = new ByteArrayInputStream(b);
    ObjectInputStream ois = new ObjectInputStream(is);
    cercle = (Cercle) ois.readObject();
    System.out.println(cercle.toString());
    rs.close();
    is.close();
    ois.close();
    psSelect.close();
    return cercle;
  }


  @Override
  public List<Cercle> getAll() {
    return null;
  }

  @Override
  public void create(Cercle cercle) throws IOException,
      ClassNotFoundException, KeyAlreadyExistException, SQLException {
    try {
    psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
    statements.add(psInsert);
    //Object obj = (Object) cercle;

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(cercle);
    byte [] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
      psInsert.setString(1, cercle.getIdentifiant());
      psInsert.setBinaryStream(2, objectIn,b.length );
      psInsert.setString(3,cercle.toString());
      psInsert.executeUpdate();
      System.out.println(objectIn);
      objectIn.close();
      os.flush();
      os.close();
      out.reset();
      out.close();

    } catch (SQLException e) {
      if (Helper.keyExist(e)){
        throw new KeyAlreadyExistException();
      }
      else throw e;
    }

    }



  @Override
  public void update(Cercle cercle) throws IOException, SQLException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(cercle);
    byte [] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psUpdate = conn.prepareStatement(
        SQL_UPDATE_OBJECT);
    psUpdate.setBinaryStream(1,objectIn,b.length );
    psUpdate.setString(2, cercle.toString());
    psUpdate.setString(3, cercle.getIdentifiant());
    psUpdate.executeUpdate();

  }

  @Override
  public void delete(Cercle cercle) throws SQLException {
    psUpdate = conn.prepareStatement(
        SQL_DELETE_OBJECT);
    psUpdate.setString(1, cercle.getIdentifiant());
    psUpdate.executeUpdate();
  }
}
