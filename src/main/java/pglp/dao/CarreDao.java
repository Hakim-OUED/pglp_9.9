package pglp.dao;

import pglp.formes.Carre;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarreDao extends Dao<Carre> {


  @Override
  public Carre get(String nom) throws SQLException, IOException, ClassNotFoundException {
    Carre carre = null;
    psSelect = conn
        .prepareStatement(SQL_DESERIALIZE_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();

    // Object object = rs.getObject(1);

    byte[] b = rs.getBytes(2);
    String n = rs.getString("description");
    ByteArrayInputStream is = new ByteArrayInputStream(b);
    ObjectInputStream ois = new ObjectInputStream(is);
    carre = (Carre) ois.readObject();
    //cercle = (Cercle) rs.getObject(2);
    carre.setIdentifiant(nom);
    System.out.println(carre.toString());
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
  public void create(Carre carre) throws SQLException, IOException, ClassNotFoundException {

    psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
    statements.add(psInsert);
    //Object obj = (Object) cercle;

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(carre);
    byte [] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);

    psInsert.setString(1, carre.getIdentifiant());
    psInsert.setBinaryStream(2, objectIn,b.length );
    psInsert.setString(3,carre.toString());
    psInsert.executeUpdate();
    System.out.println(objectIn);
    objectIn.close();
    os.flush();
    os.close();
    out.reset();
    out.close();
  }



  @Override
  public void update(Carre carre) throws IOException, SQLException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(carre);
    byte [] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psUpdate = conn.prepareStatement(
        SQL_UPDATE_OBJECT);
    psUpdate.setBinaryStream(1,objectIn,b.length );
    psUpdate.setString(2, carre.toString());
    psUpdate.setString(3, carre.getIdentifiant());
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
