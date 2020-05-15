package pglp.formes;

public class Cercle extends Forme {

   //le centre
  private Point centre;
  //le rayon
  private int rayon;

  public Point getCentre() {
    return centre;
  }

  public void setCentre(Point centre) {
    this.centre = centre;
  }

  public int getRayon() {
    return rayon;
  }

  public void setRayon(int rayon) {
    this.rayon = rayon;
  }

  public Cercle(final String nom, final int x,
                final int y, final int rayon) {
    super(nom);
    this.centre = new Point(x,y);
    this.rayon = rayon;
  }

  /**
   * Implementation du deplacement d'un cercle
   * @param x Nouvelle coordonnée X
   * @param y Nouvelle coordonée Y
   * @return le cercle déplacé
   */
  @Override
  public Forme deplacer(int x, int y) {
    this.centre.deplacer(x, y);
    return this;
  }

}
