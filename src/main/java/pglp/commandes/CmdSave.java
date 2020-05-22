package pglp.commandes;

import java.io.IOException;
import java.sql.SQLException;
import pglp.dao.Dao;
import pglp.dao.DaoFactory;
import pglp.exceptions.DrawingNotExistException;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.formes.Forme;


public class CmdSave implements Commande {
  //Identifiant du dessin à sauvegarder
  public static String identifiant;

  public CmdSave(String identifiant) {
    this.identifiant = identifiant;
  }

  @Override
  public String execute() throws SQLException, IOException,
      ClassNotFoundException, KeyAlreadyExistException, DrawingNotExistException {
    if (CmdCreate.formes.containsKey(identifiant)) {
      Forme forme = CmdCreate.formes.get(identifiant);
      Dao dao = DaoFactory.get(forme.getClass().getSimpleName());

      return dao.create(forme);
    } else {
      throw new DrawingNotExistException();
    }

  }
}
