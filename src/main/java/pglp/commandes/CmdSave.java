package pglp.commandes;

import pglp.dao.Dao;
import pglp.dao.DaoFactory;
import pglp.exceptions.DrawingNotExistException;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.formes.Forme;

import java.io.IOException;
import java.sql.SQLException;

public class CmdSave implements Commande {
  //Identifiant du dessin à sauvegarder
  public static String identifiant;

  public CmdSave(String identifiant) {
    this.identifiant = identifiant;
  }

  @Override
  public String execute() throws SQLException, IOException, ClassNotFoundException, KeyAlreadyExistException, DrawingNotExistException {
    if (CmdCreate.formes.containsKey(identifiant)){
      Forme forme = CmdCreate.formes.get(identifiant);
      Dao dao = DaoFactory.get(forme.getClass().getName());
      dao.create(forme);
      return String.valueOf('1');
    } else throw new DrawingNotExistException();

  }
}
