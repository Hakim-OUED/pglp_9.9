package pglp.commandes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pglp.exceptions.UnknowFormException;
import pglp.formes.*;

/**
 * Commande de Création de forme.
 */
public class CmdCreate implements Commande {
  //Liste des forme créé durant la session
  public static Map<String, Forme> formes = new HashMap<String, Forme>();
  //nom de la forme
  private static String nomForme;
  //Paramètres non formatté
  private static String parametres;
  //Liste des paramètres de la forme
  private static List<Integer> parsedParams = new ArrayList<>();
  //Les expression régulières de création de chaque forme
  private String regExCreateCercle = "^(cercle)["
      + "(][(]\\d+,\\d+[)],\\d+[)]$";
  private String regExCreateCarre = "^(carre)["
      + "(][(]\\d+,\\d+[)],\\d+[)]$";
  private String regExCreateRectangle = "^(rectangle)["
      + "(][(]\\d+,\\d+[)],\\d+,\\d+[)]$";
  private String regExCreateTriangle = "^(triangle)[(][(]\\d+,\\d+[)],"
      + "[(]\\d+,\\d+[)],[(]\\d+,\\d+[)][)]$";

  /**
   * Construsteur de la commande.
   * Il initialise les variale et la liste des paramètres
   */
  public CmdCreate(final String[] params) {
    nomForme = params[0];
    parametres = params[1];
    Pattern p = Pattern.compile("-?\\d+");
    Matcher m = p.matcher(params[1]);
    while (m.find()) {
      int n = Integer.parseInt(m.group());
      parsedParams.add(n);
    }
  }

  /**
   * * Methode d'execution de la commande.
   * @return le code du résultat d'execution: 1 si la commande s'est bien executé
   */
  @Override
  public String execute() throws UnknowFormException {
    int status = 0;
    if (Pattern.matches(regExCreateCarre, parametres)) {
      Carre carre = new Carre(nomForme, parsedParams.get(0), parsedParams.get(1),
          parsedParams.get(2));
      formes.put(nomForme, carre);
      status = 1;
      return String.valueOf(status);
    } else if (Pattern.matches(regExCreateCercle, parametres)) {
      Cercle cercle = new Cercle(nomForme, parsedParams.get(0), parsedParams.get(1),
          parsedParams.get(2));
      formes.put(nomForme, cercle);
      status = 1;
      return String.valueOf(status);
    } else if (Pattern.matches(regExCreateRectangle, parametres)) {
      Rectangle rectangle = new Rectangle(nomForme, parsedParams.get(0), parsedParams.get(1),
          parsedParams.get(2), parsedParams.get(3));
      formes.put(nomForme, rectangle);
      status = 1;
      return String.valueOf(status);
    } else if (Pattern.matches(regExCreateTriangle, parametres)) {
      Triangle triangle = new Triangle(nomForme, parsedParams.get(0), parsedParams.get(1),
          parsedParams.get(2), parsedParams.get(3), parsedParams.get(4), parsedParams.get(5));
      formes.put(nomForme, triangle);
      parsedParams.removeAll(parsedParams);
      status = 1;
      return String.valueOf(status);
    } else {
      throw new UnknowFormException();
    }

  }
}
