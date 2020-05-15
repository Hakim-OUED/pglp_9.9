package pglp.formes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CercleTest {
  private Cercle c1;

  @Before
  public void init(){
  c1 = new Cercle("c1",2,2,6);
  }

  @Test
  public void Testdeplacer() {
    c1.deplacer(4,5);
    assertTrue(c1.getCentre().getX()==4);
    assertTrue(c1.getCentre().getY()==5);
    String value = "identifiant= c1" +
        "--> Cercle(centre=(X:4, Y:5),rayon=6)";
    assertTrue(c1.toString().equals(value));
  }

  @Test
  public void testToString() {
    String value = "identifiant= c1" +
        "--> Cercle(centre=(X:2, Y:2),rayon=6)";
    assertTrue(c1.toString().equals(value));
  }
}