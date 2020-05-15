package pglp.formes;

public class Carre extends Forme {
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




  public Carre(final String nom, final int x,
               final int y, final int cote) {
    super(nom);
    this.origine = new Point(x,y);
    this.cote = cote;
  }

  @Override
  public String toString() {
    return super.toString()
        + "-->Carre(origine=" + origine
        + "), cote=" + cote
        + ')';
  }

  /**
   * Deplace le carré à travers le point origine
   * @param nx Nouvelle coordonnée X
   * @param ny Nouvelle coordonnée Y
   * @return le carré déplacé
   */

  @Override
  public Forme deplacer(int nx, int ny) {
    this.origine.deplacer(nx,ny);
    return this;
  }
}
