import org.sql2o.*;
public class DB{
  public  static Sql2o sql2o=new Sql2o("jdbc:postgresql://localhost:4567/ordering-system","collins","Colloski8984");
  private static Connection con=sql2o.open();
  public static Connection getConnection(){
    return con;
  }
}
