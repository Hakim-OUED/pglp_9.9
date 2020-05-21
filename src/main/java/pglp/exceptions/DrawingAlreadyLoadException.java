package pglp.exceptions;

public class DrawingAlreadyLoadException extends Exception{
  public DrawingAlreadyLoadException () {
    super("Ce dessin est dejà chargé!");
  }
}
