package pglp.commandes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import pglp.exceptions.UnloadedDrawingException;
import pglp.formes.Forme;
import pglp.formes.FormeGroupe;


/**
 * Commande pour créer un ensemble de dessin.
 * si un dessin est déja dans l'ensemble, il n'est plus ajouté.
 */
public class CmdGroup implements Commande {

  private static String nomGroup;
  private static List<String> elements = new ArrayList<>();

  /**
   * Constructeur de la Commande.
   *
   * @param params paramètres
   */
  public CmdGroup(final String[] params) {
    nomGroup = params[0];
    Pattern p = Pattern.compile(",");
    String[] parametres = p.split(params[1]);
    for (int i = 0; i < parametres.length; i++) {
      elements.add(parametres[i]);
    }
  }

  /**
   * Execute la commande.
   *
   * @return un message.
   */
  @Override
  public String execute() throws UnloadedDrawingException {
    for (String element : elements) {
      if (!CmdCreate.formes.containsKey(element)) {
        elements.clear();
        throw new UnloadedDrawingException(element);
      }
    }
    FormeGroupe groupe;
    if (CmdCreate.formes.containsKey(nomGroup)) {
      groupe = (FormeGroupe) CmdCreate.formes.get(nomGroup);
    } else {
      groupe = new FormeGroupe(nomGroup);
    }
    for (String element : elements) {
      Forme dessin = CmdCreate.formes.get(element);
      if (!groupe.getEnsemble().contains(dessin)) {
        groupe.addForme(dessin);
      }

    }
    CmdCreate.formes.put(nomGroup, groupe);
    elements.clear();

    return "Groupe " + nomGroup + " créé avec succès";
  }
}
