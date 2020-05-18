package pglp.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class Dao<T> {

  public String nomBd;
  public static Connection conn = null;
  ArrayList<Statement> statements = new ArrayList<Statement>();
  PreparedStatement psInsert;
  PreparedStatement psUpdate;
  PreparedStatement psSelect;
  ResultSet rs = null;
  static final String SQL_SERIALIZE_OBJECT = "INSERT INTO dessin(id, objet, description) VALUES (?,?,?)";
  static final String SQL_DESERIALIZE_OBJECT = "SELECT * FROM dessin WHERE id = ?";
  static final String SQL_UPDATE_OBJECT = "UPDATE dessin set objet = ? , description = ? WHERE id = ?";
  static final String SQL_DELETE_OBJECT = "DELETE FROM dessin WHERE id = ?";


  public Dao() {

  }



  public abstract T get(String nom) throws SQLException, IOException, ClassNotFoundException;

  public abstract List<T> getAll();

  public abstract void create(T t) throws SQLException, IOException, ClassNotFoundException;

  public abstract void update(T t) throws IOException, SQLException;

  public abstract void delete(T t) throws SQLException;

}
