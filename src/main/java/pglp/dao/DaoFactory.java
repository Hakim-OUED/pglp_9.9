package pglp.dao;

import pglp.formes.*;

public class DaoFactory {

  private DaoFactory() {
  }
  public static Dao get(String forme){

    Dao dao;
    switch (forme) {
      case "Cercle":
        dao = new CercleDao();
        break;
      case "Carre":
        dao = new CarreDao();
        break;
      case "Rectangle":
        dao = new RectangleDao();
        break;
      case "Triangle":
        dao = new TriangleDao();
        break;
      case "FormeGroup":
        dao = new FormeGroupeDao();
        break;
      default: dao =null;
    }
    return dao;
  }

  public static Dao<Cercle> getDaoCercle() {
    return new CercleDao();
  }

  public static Dao<Carre> getDaoCarre() {
    return new CarreDao();
  }

  public static Dao<Rectangle> getDaoRectangle() {
    return new RectangleDao();
  }

  public static Dao<Triangle> getDaoTriangle() {
    return new TriangleDao();
  }


}
