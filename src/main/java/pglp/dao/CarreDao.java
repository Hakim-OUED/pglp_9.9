package pglp.dao;


import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pglp.formes.Carre;

public class CarreDao extends Dao<Carre> {

  @Override
  public Carre getSpecific(String nom) throws SQLException, IOException,
      ClassNotFoundException {
    psSelect = conn
        .prepareStatement(SQL_SELECT_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();
    byte[] b = rs.getBytes(2);
    ByteArrayInputStream is = new ByteArrayInputStream(b);
    ObjectInputStream ois = new ObjectInputStream(is);
    Carre carre = null;
    carre = (Carre) ois.readObject();
    rs.close();
    is.close();
    ois.close();
    psSelect.close();
    return carre;
  }


  @Override
  public List<Carre> getAll() {
    return null;
  }

  @Override
  public String create(Carre carre) throws SQLException, IOException, ClassNotFoundException {

    psInsert = conn.prepareStatement(SQL_INSERT_OBJECT);
    statements.add(psInsert);
    //Object obj = (Object) cercle;

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(carre);
    byte[] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);

    psInsert.setString(1, carre.getIdentifiant());
    psInsert.setBinaryStream(2, objectIn, b.length);
    psInsert.executeUpdate();
    objectIn.close();
    os.flush();
    os.close();
    out.reset();
    out.close();
    return carre.getIdentifiant() + " a été bien sauvegardé";
  }


  @Override
  public void update(Carre carre) throws IOException, SQLException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(carre);
    byte[] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psUpdate = conn.prepareStatement(
        SQL_UPDATE_OBJECT);
    psUpdate.setBinaryStream(1, objectIn, b.length);
    psUpdate.setString(2, carre.toString());
    psUpdate.executeUpdate();

  }


  @Override
  public void delete(Carre carre) throws SQLException {
    psUpdate = conn.prepareStatement(
        SQL_DELETE_OBJECT);
    psUpdate.setString(1, carre.getIdentifiant());
    psUpdate.executeUpdate();
  }

}
