import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
public  class Order{
  private int id;
  private double price;
  private long time;
  private String hotel;
  private String waiter;
  public Order(){
    setTime();
  }
  public int getId(){
    return  this.id;
  }
  public double getPrice(){
    return this.price;
  }
  public String getTime(){
  return new SimpleDateFormat("yyyy:MM:dd")
    .format(new Timestamp(time));
  }
  public String getHotel(){
    return this.hotel;
  }
  public String getWaiter(){
    return this.waiter;
  }
  public void setPrice(double price){
    this.price=price;
  }
  public  void setHotel(String hotel){
    this.hotel=hotel;
  }
  public void setWaiter(String waiter){
    this.waiter=waiter;
  }
  public  void setTime(){
    this.time=new Date().getTime();
  }
  public boolean save(){
    try{
      String sql="INSERT INTO orders (price,time,hotel,waiter) " +
      "VALUES (:price,:time,:hotel,:waiter);";
      this.id=(int)DB.getConnection().createQuery(sql,true)
      .addParameter("price",this.price)
      .addParameter("time",this.time)
      .addParameter("hotel",this.hotel)
      .addParameter("waiter",this.waiter)
      .executeUpdate()
      .getKey();
      return  true;
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    return false;
  }
}
