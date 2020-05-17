package pglp.dao;

import pglp.formes.Cercle;

public class DaoFactory {

  private DaoFactory() {
  }

  public static Dao<Cercle> getDaoCercle() {
    return new CercleDao();
  }


}
