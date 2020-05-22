package pglp.commandes;

import java.io.IOException;
import java.sql.SQLException;
import pglp.exceptions.UnknowFormException;

public class CmdHelp implements Commande {
  @Override
  public String execute() throws UnknowFormException,
      SQLException, IOException, ClassNotFoundException {

    return null;
  }
}
