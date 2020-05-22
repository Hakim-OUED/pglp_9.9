package pglp.formes;

import java.io.Serializable;

/**
 * Classe implementant la forme Rectangle.
 */

public class Rectangle extends Forme implements Serializable {

  /**
   * uid Serial.
   */
  private static final long serialVersionUID = 1L;
  private static int id = 0;

  //origine du rectangle (le point en haut à gauche)
  private Point origine;

  //Longueur du rectangle
  private int lon;

  //Largeur du rectangle
  private int lar;

  public Point getOrigine() {
    return origine;
  }

  public void setOrigine(Point origine) {
    this.origine = origine;
  }

  public int getLon() {
    return lon;
  }

  public void setLon(int lon) {
    this.lon = lon;
  }

  public int getLar() {
    return lar;
  }

  public void setLar(int lar) {
    this.lar = lar;
  }

  /**
   * Constructeur du rectangle.
   * @param nom nom du dessin
   * @param x abcisse de l'origine (Point en haut à gauche)
   * @param y ordonnée de l'origine (Point en haut à gauche)
   * @param longueur Longueur du rectangle
   * @param largeur Largeur du rectangle
   */

  public Rectangle(final String nom,
                   final int x, final int y,
                   final int longueur, final int largeur) {
    super(nom);
    this.origine = new Point(x, y);
    this.lon = longueur;
    this.lar = largeur;
    this.id += 1;
  }

  @Override
  public Forme deplacer(int nx, int ny) {
    this.origine.deplacer(nx, ny);
    return this;
  }

  @Override
  public String toString() {
    return super.toString()
        + "-->Rectangle("
        + "origine=(" + origine
        + "), lon=" + lon
        + ", lar=" + lar
        + ')';
  }
}
