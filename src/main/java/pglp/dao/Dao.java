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
  static final String SQL_DESERIALIZE_OBJECT = "SELECT objet FROM dessin WHERE id = ?";


  public Dao() {

  }



  abstract T get(String nom) throws SQLException, IOException, ClassNotFoundException;

  abstract List<T> getAll();

  abstract void create(T t) throws SQLException, IOException, ClassNotFoundException;

  abstract void update(T t, String[] params);

  abstract void delete(T t);

}
