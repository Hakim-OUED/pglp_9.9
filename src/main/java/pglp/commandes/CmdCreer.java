package pglp.commandes;

import pglp.exceptions.UnknowFormException;
import pglp.formes.Forme;

import java.util.HashMap;
import java.util.Map;

public class CmdCreer implements Commande {

  public static Map<String,String> parametres = new HashMap<>();
  public static Map<String,Forme> formes = new HashMap<String, Forme>();


  @Override
  public void execute() throws UnknowFormException {
    if (parametres.get("value").toLowerCase().startsWith("cercle")){

    }
    else if (parametres.get("value").toLowerCase().startsWith("carre")){

    }
    else if(parametres.get("value").startsWith("rectangle")){

    }
    else if (parametres.get("value").startsWith("triangle")){

    }
    else throw new UnknowFormException();
    //formes.put(forme.getIdentifiant(),forme);
  }
}
