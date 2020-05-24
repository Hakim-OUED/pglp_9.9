package pglp.commandes;

import java.io.IOException;
import java.sql.SQLException;
import pglp.exceptions.UnknowFormException;

public class CmdHelp implements Commande {
  @Override
  public String execute() throws UnknowFormException,
      SQLException, IOException, ClassNotFoundException {
    String help ="## Création d'une forme\n" +
        "- > Cercle:\n" +
        "Nom_forme = Cercle((x,y), r)\n" +
        "x: abcisse du centre\n" +
        "y: ordonnée du centre\n" +
        "r: rayon\n" +
        "\n" +
        "- > Carre: \n" +
        "Nom_forme = Carre((x,y), c)\n" +
        "x: abcisse du point origine (en haut à gauche)\n" +
        "y: ordonnée du point origine\n" +
        "c: coté\n" +
        "\n" +
        "- >Rectangle:\n" +
        "Nom_forme = Rectangle((x,y), lon,lar)\n" +
        "x: abcisse du point origine (en haut à gauche)\n" +
        "y: ordonnée du point origine\n" +
        "lon: longueur\n" +
        "lar: largeur\n" +
        "\n" +
        "- >Triangle:\n" +
        "Nom_forme = Triangle((x1,y1), (x2,y2), (x3,y3)) \n" +
        "xi: abcisse du point i \n" +
        "yi: ordonnée du point i\n" +
        "\n" +
        "## Regrouper des formes\n" +
        "- > Nom_groupe = group(forme1, forme2, ....., formeN)\n" +
        "\n" +
        "## Sauvegarder une forme ou un ensemble de forme\n" +
        "- > Save(nom_forme) ou save(nom_groupe)\n" +
        "\n" +
        "## Afficher une forme ou un groupe de forme\n" +
        "- > Show(nom_forme) ou Show(nom_groupe) \n" +
        "\n" +
        "## Charger une forme ou un ensemble de forme sauvegardé dans la BD\n" +
        "- > ```Load(nom_forme) ou load(nom_groupe)\n" +
        "\n" +
        "## Deplacer une forme ou un groupe\n" +
        "- > Move(nom_forme, (nx,ny)) ou move(nom_groupe, (nx,ny)) \n" +
        "nx: augmentation de l'abcisse\n" +
        "ny: augmentation de l'ordonnée\n" +
        "- > NB: Il faut au préalable créer ou charger la figure s'elle est dans la BD\n" +
        "\n" +
        "## Afficher la liste des commandes\n" +
        "- > Help \n" +
        "## Quitter le programme\n" +
        "- > Quit\n";

    return help;
  }
}
