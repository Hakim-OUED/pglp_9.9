package pglp.exceptions;

public class NegativeValueException extends Exception {
  public NegativeValueException() {
    super("Les valeurs négatives ne sont pas autorisé");
  }
}
