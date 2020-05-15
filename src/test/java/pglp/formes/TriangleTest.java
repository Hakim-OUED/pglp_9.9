package pglp.formes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

  Triangle tri;

  @Before
  public void init() {
    tri = new Triangle("tri",5,1,2,-3,8,-3);
  }

  @Test
  public void deplacer() {
    tri.deplacer(2,3);
    assertFalse(tri.getPoint3().getY()==-3);
    assertTrue(tri.getPoint2().getY()==0);
    assertTrue(tri.getPoint1().getX()==7);
    assertTrue(tri.getPoint2().getX()==4);
  }

  @Test
  public void testToString() {
    String value = "identifiant= tri"
        +"-->Triangle(point1=(X:5, Y:1),"
        +" point2=(X:2, Y:-3), "
        +"point3=(X:8, Y:-3))";

    assertTrue(tri.toString().equals(value));
  }
}