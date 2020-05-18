package pglp.exceptions;

public class UnknowFormException extends Exception {
  public UnknowFormException() {
    super("Ce type de figure n'est pas pris en charge");
  }
}
