package pglp.commandes;

public class CmdQuit implements Commande {
  @Override
  public String execute() {
    System.out.println("Fin de l'execution, Au revoir!");
    System.exit(0);
    return String.valueOf(1);
  }
}
