package pglp.formes;

public class Rectangle extends Forme {

  //origine du rectangle (le point en haut à gauche)
  private Point origine;

  //Longueur du rectangle
  private int lon;

  //Largeur du rectangle
  private int lar;

   public Rectangle(final String nom,
                    final int x, final int y,
                   final int longueur, final int largeur){
     super(nom);
     this.origine = new Point(x,y);
    this.lon = longueur;
    this.lar = largeur;
  }

  @Override
  public Forme deplacer(int nx, int ny) {
    this.origine.deplacer(nx,ny);
    return this;
  }
}
