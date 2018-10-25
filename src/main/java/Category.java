import java.util.List;
public  class Category{
private int id;
private String name;
private String hotel;
public void setName(String name){
  this.name=name;
}
public  void setHotel(String hotel){
  this.hotel=hotel;
}
public int getId(){
  return this.id;
}
public String getName(){
  return this.name;
}
public String getHotel(){
  return this.hotel;
}
public boolean save (){
  try{
   String sql="INSERT INTO category (name,hotel) VALUES (:name,:hotel);";
   this.id=(int)DB.getConnection().createQuery(sql,true)
  .addParameter("name",this.name)
  .addParameter("hotel",this.hotel)
  .executeUpdate()
  .getKey();
  return true;
  }catch(Exception ex){
    System.out.println(ex.getMessage());
  }
  return false;
}
public boolean isExisting(){
    String name=null;
  try {
    String sql="SELECT name FROM category WHERE hotel=:hotel AND name=:name;";
    name=DB.getConnection().createQuery(sql)
    .addParameter("name",this.name)
    .addParameter("hotel",this.hotel)
    .executeAndFetchFirst(String.class);
  }catch(Exception ex){
      System.out.println(ex.getMessage());
  }
  System.out.println(name);
  return name==null? false : true;
}
public static List<Category> getCategory(String name){
    List<Category> categorys=null;
    try{
      String sql="SELECT id,name,hotel FROM category WHERE hotel=:hotel;";
      System.out.println(name);
      categorys=DB.getConnection().createQuery(sql)
      .addParameter("hotel",name)
      .executeAndFetch(Category.class);
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return categorys;
}
}
