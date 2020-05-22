package pglp.exceptions;



public class UnloadedDrawingException extends Exception {
  /**
   * Exception lorsqu'un dessin dans la BD n'est pas chargé avant utilisation.
   */
  public UnloadedDrawingException(String drawing) {
    super(drawing + " n'existe pas ou n'est pas chargé!"
        + "Veillez le charger ou le créer avant.");
  }
}
