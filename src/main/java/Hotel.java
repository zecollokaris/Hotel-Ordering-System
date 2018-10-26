import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class Hotel implements Credentials{
  private String name;
  private String password;
  private Map<String,Object> lists=new HashMap<String,Object>();
  public void setName(String name){
    this.name=name;
  }
  public void setPassword(String password){
    this.password=password;
  }
  public String getName(){
    return this.name;
  }
  public  String getPassword(){
    return this.password;
  }
  public boolean authenticated(String name,String p){
    try{
      String sql="SELECT password FROM hotels WHERE name=:name";
      String password=DB.getConnection().createQuery(sql)
      .addParameter("name",name)
      .executeAndFetchFirst(String.class);
      if(password.equals(p)){
        return true;
      }
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return false;
  }
  public  boolean register(){
    try{
      String sql="INSERT INTO hotels (name,password) VALUES (:name,:password);";
      DB.getConnection().createQuery(sql)
      .addParameter("name",this.name)
      .addParameter("password",this.password)
      .executeUpdate();
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
      return false;
    }
    return true;
  }
  public static  List<String> getHotels(){
    List<String> list=null;
    try {
      list=DB.getConnection()
      .createQuery("SELECT name FROM hotels LIMIT 10;")
      .executeAndFetch(String.class);
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return list;
  }
  // Gets all orders For That Hotel Name
  public Map<String,Object> addDataOnAuth(){
    try{
      Integer amount=DB.getConnection()
      .createQuery("SELECT SUM(price) FROM orders WHERE hotel=:name")
      .addParameter("name",this.name)
      .executeAndFetchFirst(Integer.class);
      lists.put("cash",amount);
      String sqlOrders="SELECT id,price,time,hotel,waiter FROM orders WHERE hotel=:name";
      List<Order> listOfOrders=DB.getConnection().createQuery(sqlOrders)
      .addParameter("name",this.name)
      .executeAndFetch(Order.class);
      lists.put("orders",listOfOrders);
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return lists;
  }
  public static boolean addWaiter(String hotel,String name){
    try{
      String sql="UPDATE waiters SET hotel=:hotel WHERE name=:name;";
      DB.getConnection().createQuery(sql)
      .addParameter("hotel",hotel)
      .addParameter("name",name)
      .executeUpdate();
      return true;
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return true;
  }
}
