package pglp.dao;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pglp.Helper;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.formes.Cercle;

public class CercleDao extends Dao<Cercle> {

  public CercleDao() {

  }

  @Override
  public Cercle getSpecific(String nom) throws SQLException, IOException, ClassNotFoundException {

    psSelect = conn
        .prepareStatement(SQL_DESERIALIZE_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();
    byte[] b = rs.getBytes(2);
    ByteArrayInputStream is = new ByteArrayInputStream(b);
    ObjectInputStream ois = new ObjectInputStream(is);
    Cercle cercle = null;
    cercle = (Cercle) ois.readObject();
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
  public String create(Cercle cercle) throws IOException,
      ClassNotFoundException, KeyAlreadyExistException, SQLException {
    try {
      psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
      statements.add(psInsert);
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ObjectOutputStream os = new ObjectOutputStream(out);
      os.writeObject(cercle);
      byte[] b = out.toByteArray();
      ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
      psInsert.setString(1, cercle.getIdentifiant());
      psInsert.setBinaryStream(2, objectIn, b.length);
      psInsert.executeUpdate();
      objectIn.close();
      os.flush();
      os.close();
      out.reset();
      out.close();

    } catch (SQLException e) {
      if (Helper.keyExist(e)) {
        throw new KeyAlreadyExistException();
      } else {
        throw e;
      }
    }

    return cercle.getIdentifiant() + " a été bien sauvegardé";
  }


  @Override
  public void update(Cercle cercle) throws IOException, SQLException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(cercle);
    byte[] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psUpdate = conn.prepareStatement(
        SQL_UPDATE_OBJECT);
    psUpdate.setBinaryStream(1, objectIn, b.length);
    psUpdate.setString(2, cercle.toString());
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
