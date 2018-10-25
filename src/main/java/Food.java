import  java.util.List;
public  class Food{
  private int id;
  private String name;
  private double price;
  private String hotel;

  public void setName(String name){
    this.name=name;
  }
  public void setPrice(double price){
    this.price=price;
  }
  public void setHotel(String hotel){
    this.hotel=hotel;
  }
  public int getId(){
    return  this.id;
  }
  public String getName(){
    return this.name;
  }
  public  double getPrice(){
    return this.price;
  }
  public  String getHotel(){
    return this.hotel;
  }
  public boolean addToMenu(int catid){
    try {
      String sql="INSERT INTO menu (cat_id,food_id,hotel) VALUES (:cat_id,:food_id,:hotel)";
      DB.getConnection().createQuery(sql)
      .addParameter("cat_id",catid)
      .addParameter("food_id",this.id)
      .addParameter("hotel",this.hotel)
      .executeUpdate();
      return true;
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return false;
  }
  public  boolean save(){
    try {
      String sql="INSERT INTO foods (name,price,hotel) VALUES (:name,:price,:hotel);";
      this.id=(int) DB.getConnection().createQuery(sql,true)
      .addParameter("name",this.name)
      .addParameter("price",this.price)
      .addParameter("hotel",this.hotel)
      .executeUpdate()
      .getKey();
      return true;
    }catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return false;
  }
  public static List<Food> getFoods(String hotel,int catid){
  List<Food> foods=null;
  try{
  String sql="SELECT foods.id,foods.name,foods.price,foods.hotel FROM menu JOIN foods "+
  "ON (foods.id=food_id) WHERE cat_id=:cat_id AND menu.hotel=:hotel";
   foods=DB.getConnection().createQuery(sql)
   .addParameter("hotel",hotel)
   .addParameter("cat_id",catid)
   .executeAndFetch(Food.class);
  }
  catch (Exception e) {
    System.out.println(e.getMessage());
  }
   return foods;
  }
}
