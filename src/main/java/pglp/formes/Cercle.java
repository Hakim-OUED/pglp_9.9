package pglp.formes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe implementant la forme Cercle
 */
public class Cercle extends Forme implements Serializable {

  /**
   * uid Serial.
   */
  private static final long serialVersionUID = 1L;
  private static int id = 0;

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
    this.id +=1;
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

  @Override
  public String toString() {
    return super.toString()
        + "--> Cercle(centre=("
        + this.centre
        +"),rayon="+this.rayon+")";
  }


}
