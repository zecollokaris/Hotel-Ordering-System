import  java.util.List;
import  java.util.Map;
import  java.util.HashMap;
public  class Waiter implements Credentials{
  private String name;
  private String password;
  private String hotel;
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
  public  boolean register(){
    try {
     String sql="INSERT INTO waiters (hotel,name,password) VALUES (:hotel,:name,:password);";
     DB.getConnection().createQuery(sql)
     .addParameter("hotel","none")
     .addParameter("name",this.name)
     .addParameter("password",this.password)
     .executeUpdate();
     return true;
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return false;
  }
  public  boolean authenticated(String name,String p){
     String password=DB.getConnection().createQuery("SELECT password FROM waiters WHERE name=:name")
     .addParameter("name",name)
     .executeAndFetchFirst(String.class);
     if(password.equals(p)){
       return true;
     }
    return false;
  }
  public Map<String,Object> addDataOnAuth(){
    try {
      List<Order> orders=DB.getConnection().createQuery("SELECT * FROM orders WHERE waiter=:name;")
     .addParameter("name",this.name)
     .executeAndFetch(Order.class);
      lists.put("orders",orders);
     Integer cash=DB.getConnection().createQuery("SELECT SUM(price) FROM orders WHERE waiter=:name;")
     .addParameter("name",this.name)
     .executeAndFetchFirst(Integer.class);
      lists.put("cash",cash);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return lists;
  }

}
