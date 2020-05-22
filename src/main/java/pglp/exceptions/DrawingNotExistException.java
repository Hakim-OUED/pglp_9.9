package pglp.exceptions;

public class DrawingNotExistException extends Exception {
  public DrawingNotExistException() {
    super("Aucun dessin de ce nom n'a été créé! "
        + "Veillez le créer avant de le sauvegarder.");
  }
}
