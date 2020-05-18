package pglp.commandes;

import pglp.dao.Dao;
import pglp.dao.DaoFactory;
import pglp.formes.Cercle;
import pglp.formes.Forme;

import java.io.IOException;
import java.sql.SQLException;

import static pglp.dao.DaoFactory.getDaoCercle;

public class CmdSauvegarder implements Commande {

  public static String identifiant;

  @Override
  public void execute() throws SQLException, IOException, ClassNotFoundException {
    if (CmdCreer.formes.containsKey(identifiant)){
      Forme forme = CmdCreer.formes.get(identifiant);
      Dao dao = DaoFactory.create(forme.getClass().getName());
      dao.create(forme);

    }
  }
}
