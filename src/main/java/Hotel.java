import  java.util.List;
public class Hotel implements Credentials{
  private String name;
  private String password;
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
}
