package pglp.exceptions;

public class KeyAlreadyExistException extends Exception {
  public KeyAlreadyExistException() {
    super("Un objet de ce nom existe déjà");
  }
}
