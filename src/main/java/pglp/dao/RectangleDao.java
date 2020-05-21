package pglp.dao;

import pglp.formes.Rectangle;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RectangleDao extends Dao<Rectangle> {
  @Override
  public Rectangle getSpecific(String nom) throws SQLException, IOException, ClassNotFoundException {
    Rectangle rectangle = null;
    psSelect = conn
        .prepareStatement(SQL_DESERIALIZE_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();

    // Object object = rs.getObject(1);

    byte[] b = rs.getBytes(2);
    ByteArrayInputStream is = new ByteArrayInputStream(b);
    ObjectInputStream ois = new ObjectInputStream(is);
    rectangle = (Rectangle) ois.readObject();
    rs.close();
    is.close();
    ois.close();
    psSelect.close();
    return rectangle;
  }


  @Override
  public List<Rectangle> getAll() {
    return null;
  }

  @Override
  public String create(Rectangle rectangle) throws SQLException, IOException, ClassNotFoundException {

    psInsert = conn.prepareStatement(SQL_SERIALIZE_OBJECT);
    statements.add(psInsert);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(rectangle);
    byte [] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);

    psInsert.setString(1, rectangle.getIdentifiant());
    psInsert.setBinaryStream(2, objectIn,b.length );
    psInsert.setString(3,rectangle.toString());
    psInsert.executeUpdate();
    objectIn.close();
    os.flush();
    os.close();
    out.reset();
    out.close();
    return rectangle.getIdentifiant() + " a été bien sauvegardé";
  }



  @Override
  public void update(Rectangle rectangle) throws IOException, SQLException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(rectangle);
    byte [] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psUpdate = conn.prepareStatement(
        SQL_UPDATE_OBJECT);
    psUpdate.setBinaryStream(1,objectIn,b.length );
    psUpdate.setString(2, rectangle.toString());
    psUpdate.setString(3, rectangle.getIdentifiant());
    psUpdate.executeUpdate();

  }


  @Override
  public void delete(Rectangle rectangle) throws SQLException {
    psUpdate = conn.prepareStatement(
        SQL_DELETE_OBJECT);
    psUpdate.setString(1, rectangle.getIdentifiant());
    psUpdate.executeUpdate();
  }

}
