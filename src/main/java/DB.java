import org.sql2o.*;
public class DB{
  public  static Connection con=new Sql2o("jdbc:postgresql://localhost:5432/ordering_system","collins","Colloski8984").open();
  public static Connection getConnection(){
    return con;
  }
}
