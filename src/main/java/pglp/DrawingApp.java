package pglp;

import pglp.exceptions.NegativeValueException;

import java.io.IOException;

public class DrawingApp {

  /**
   * Execute le programme.
   * @param args ensemble d'arguments
   * @throws IOException Exception des saisies
   */
  public static void run(final String[] args) throws IOException {

    DrawingTUI drawingTUI = new DrawingTUI();
    while (true) {
      drawingTUI.nextCommand();
    }
  }
}
