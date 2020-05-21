package pglp.commandes;

import org.junit.BeforeClass;
import org.junit.Test;
import pglp.exceptions.DrawingNotExistException;
import pglp.exceptions.KeyAlreadyExistException;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CmdSaveTest {
  static CmdSave cmd;

  @BeforeClass
  public static void init() {
    cmd = new CmdSave("c23");
  }
  @Test
  public void execute() {
    try {
      String result = cmd.execute();
    } catch (SQLException e) {
      e.getCause();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.getMessage();
    } catch (KeyAlreadyExistException e) {
      e.printStackTrace();
    } catch (DrawingNotExistException e) {
      System.out.println(e.getMessage());
    }
  }
}