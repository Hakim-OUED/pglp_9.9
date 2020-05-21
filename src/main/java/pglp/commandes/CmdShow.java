package pglp.commandes;

import pglp.dao.Dao;
import pglp.exceptions.DrawingNotExistException;
import pglp.exceptions.KeyAlreadyExistException;
import pglp.exceptions.UnknowFormException;

import java.io.IOException;
import java.sql.SQLException;

public class CmdShow implements Commande {

  private static String identifiant;
  public CmdShow(String identifiant) {
    this.identifiant = identifiant;
  }
  @Override
  public String execute() throws SQLException, IOException, ClassNotFoundException, KeyAlreadyExistException, DrawingNotExistException {
    if (CmdCreate.formes.containsKey(identifiant)){
      return CmdCreate.formes.get(identifiant).toString();
    } else {
      return Dao.get(identifiant).toString();
    }

  }
}
