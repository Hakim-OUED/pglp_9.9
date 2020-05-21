package pglp.dao;

import pglp.formes.*;

public class DaoFactory {

  private DaoFactory() {
  }
  public static Dao get(String forme){
    Dao dao = null;
    switch (forme) {
      case "Cercle":
        dao = new CercleDao();
        break;
      case "Carre":
        dao = new CarreDao();
      case "Rectangle":
        dao = new RectangleDao();
      case "Triangle":
        dao = new TriangleDao();
      case "FormeGroup":
        dao = new FormeGroupeDao();
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
