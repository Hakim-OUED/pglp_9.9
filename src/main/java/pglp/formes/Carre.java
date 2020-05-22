package pglp.formes;

import java.io.Serializable;

/**
 * Classe implementant la forme Carré.
 */
public class Carre extends Forme implements Serializable {

  /**
   * uid Serial.
   */
  private static final long serialVersionUID = 1L;
  private static int id = 0;

  //Origine du carré (le point en haut à gauche)
  private Point origine;

  //le coté du carré
  private int cote;

  public Point getOrigine() {
    return origine;
  }

  public void setOrigine(Point origine) {
    this.origine = origine;
  }

  public int getCote() {
    return cote;
  }

  public void setCote(int cote) {
    this.cote = cote;
  }

  /**
   * Constructeur du carré.
   *
   * @param nom  nom du dessin.
   * @param x    abcisse du point origine (Point en haut à gauche)
   * @param y    ordonnée du point origine (Point en haut à gauche)
   * @param cote coté du carré
   */
  public Carre(final String nom, final int x,
               final int y, final int cote) {
    super(nom);
    this.origine = new Point(x, y);
    this.cote = cote;
    this.id += 1;
  }

  @Override
  public String toString() {
    return super.toString()
        + "-->Carre(origine=" + origine
        + "), cote=" + cote
        + ')';
  }

  /**
   * Deplace le carré à travers le point origine.
   *
   * @param nx Nouvelle coordonnée X
   * @param ny Nouvelle coordonnée Y
   * @return le carré déplacé
   */

  @Override
  public Forme deplacer(int nx, int ny) {
    this.origine.deplacer(nx, ny);
    return this;
  }
}
