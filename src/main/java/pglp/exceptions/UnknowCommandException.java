package pglp.exceptions;

public class UnknowCommandException extends Exception {
  public UnknowCommandException(){
    super("Syntaxe incorrecte ou Commande non pris en charge");
  }
}
