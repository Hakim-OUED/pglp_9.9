package pglp.commandes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import pglp.exceptions.*;
import pglp.formes.Forme;
import pglp.formes.FormeGroupe;

/**
 * Commande pour créer un ensemble
 */
public class CmdGroup implements Commande {

  private static String nomGroup;
  private static List<String> elements = new ArrayList<>();

  public CmdGroup(final String[] params) {
    nomGroup = params[0];
    Pattern p = Pattern.compile(",");
    String[] parametres = p.split(params[1]);
    for (int i = 0; i < parametres.length; i++) {
      elements.add(parametres[i]);
    }
  }

  @Override
  public String execute() throws UnknowFormException, SQLException, IOException, ClassNotFoundException, KeyAlreadyExistException, DrawingNotExistException, UnloadedDrawingException, DrawingAlreadyLoadException {
    for (String element : elements) {
      if (!CmdCreate.formes.containsKey(element)){
        elements.removeAll(elements);
        throw new UnloadedDrawingException(element);
      }
    }
    FormeGroupe groupe;
    if (CmdCreate.formes.containsKey(nomGroup)){
      groupe = (FormeGroupe) CmdCreate.formes.get(nomGroup);
    } else {
      groupe = new FormeGroupe(nomGroup);
    }
    for (String element : elements) {
      Forme dessin = CmdCreate.formes.get(element);
      if (!groupe.getEnsemble().contains(dessin)){
        groupe.addForme(dessin);
      }

    }
    CmdCreate.formes.put(nomGroup,groupe);
    elements.removeAll(elements);

    return "Groupe " + nomGroup + " créé avec succès";
  }
}
