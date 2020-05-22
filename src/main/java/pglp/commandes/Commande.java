package pglp.commandes;


import java.io.IOException;
import java.sql.SQLException;
import pglp.exceptions.*;

/**
 * Interface des Commandes.
 *
 * @author Hakim OUED
 * @since 17/03/2020
 */

public interface Commande {
  /**
   * Methode d'execution de la commande.
   * @return le code du résultat d'execution: 1 si la commande s'est bien executé
   */
  String execute() throws UnknowFormException, SQLException,
      IOException, ClassNotFoundException, KeyAlreadyExistException,
      DrawingNotExistException, UnloadedDrawingException, DrawingAlreadyLoadException;

}

