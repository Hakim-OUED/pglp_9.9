package pglp.commandes;


import pglp.exceptions.UnknowFormException;
import pglp.formes.Forme;

import java.io.IOException;
import java.sql.SQLException;

public interface Commande {
  /**
   * Interface des Commandes.
   * @author Hakim OUED
   * @since 17/03/2020
   */
  void execute() throws UnknowFormException, SQLException, IOException, ClassNotFoundException;

}

