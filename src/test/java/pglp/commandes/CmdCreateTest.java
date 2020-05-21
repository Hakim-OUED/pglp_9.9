package pglp.commandes;

import org.junit.BeforeClass;
import org.junit.Test;
import pglp.exceptions.UnknowFormException;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CmdCreateTest {
  static CmdCreate cmd;

  @BeforeClass
  public static void init(){
    String saisie = "rec1=rectangle((1,2),3,6)";
    Pattern p = Pattern.compile("=");
    String[] params = p.split(saisie,2);
    cmd = new CmdCreate(params);
  }
  @Test
  public void execute() throws UnknowFormException {
    String result = cmd.execute();
    assertTrue(CmdCreate.formes.containsKey("rec1"));
  }
}