package pglp.commandes;

import pglp.formes.Forme;

public class CmdQuit implements Commande {
  @Override
  public void execute() {
    System.out.println("Fin de l'execution, Au revoir!");
    System.exit(0);
  }
}
