package pglp.exceptions;

import pglp.DrawingTUI;

public class UnloadedDrawingException extends Exception {
  public UnloadedDrawingException() {
    super("Le dessin que vous essayé de deplacer" +
        " n'existe pas ou n'est pas chargé!\n" +
        "Veillez le charger ou le créer avant.");
  }
}
