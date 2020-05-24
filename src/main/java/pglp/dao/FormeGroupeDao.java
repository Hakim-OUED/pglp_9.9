package pglp.dao;


import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pglp.formes.FormeGroupe;

public class FormeGroupeDao extends Dao<FormeGroupe> {
  /**
   * Sélectionner un ensemble de dessins.
   * @param nom nom de l'ensemble à sélectionner
   * @return L'ensemble des dessins de ce group.
   * @throws SQLException SQL Exception
   * @throws IOException IOException
   * @throws ClassNotFoundException Classe non trouvé
   */
  @Override
  public FormeGroupe getSpecific(String nom) throws SQLException,
      IOException, ClassNotFoundException {
    psSelect = conn
        .prepareStatement(SQL_SELECT_OBJECT);
    psSelect.setString(1, nom);
    ResultSet rs = psSelect.executeQuery();
    rs.next();
    byte[] b = rs.getBytes(2);
    ByteArrayInputStream is = new ByteArrayInputStream(b);
    ObjectInputStream ois = new ObjectInputStream(is);
    FormeGroupe formeGroupe = null;
    formeGroupe = (FormeGroupe) ois.readObject();
    formeGroupe.setIdentifiant(nom);
    rs.close();
    is.close();
    ois.close();
    psSelect.close();
    return formeGroupe;
  }


  @Override
  public List<FormeGroupe> getAll() {
    return null;
  }

  @Override
  public String create(FormeGroupe formeGroupe) throws SQLException,
      IOException, ClassNotFoundException {

    psInsert = conn.prepareStatement(SQL_INSERT_OBJECT);
    statements.add(psInsert);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(formeGroupe);
    byte[] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psInsert.setString(1, formeGroupe.getIdentifiant());
    psInsert.setBinaryStream(2, objectIn, b.length);
    psInsert.executeUpdate();
    objectIn.close();
    os.flush();
    os.close();
    out.reset();
    out.close();
    return formeGroupe.getNom() + " a été bien sauvegardé";
  }


  @Override
  public void update(FormeGroupe formeGroupe) throws IOException, SQLException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(formeGroupe);
    byte[] b = out.toByteArray();
    ByteArrayInputStream objectIn = new ByteArrayInputStream(b);
    psUpdate = conn.prepareStatement(
        SQL_UPDATE_OBJECT);
    psUpdate.setBinaryStream(1, objectIn, b.length);
    psUpdate.setString(2, formeGroupe.toString());
    psUpdate.executeUpdate();

  }

  @Override
  public void delete(FormeGroupe formeGroupe) throws SQLException {
    psUpdate = conn.prepareStatement(
        SQL_DELETE_OBJECT);
    psUpdate.setString(1, formeGroupe.getIdentifiant());
    psUpdate.executeUpdate();
  }
}
