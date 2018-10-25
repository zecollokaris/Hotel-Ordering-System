import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        ObjectMapper om=new ObjectMapper();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        setPort(port);
        get("/getHotelList",(req,res)->{
          return om.writeValueAsString(Hotel.getHotels());
        });
        post("/registerHotel",(req,res)->{
          Hotel hotel=new Hotel();
          hotel.setName(req.queryParams("name"));
          hotel.setPassword(req.queryParams("password"));
          if(hotel.register()){
              return  om.writeValueAsString(hotel);
          }
          return false;
        });
        get("/hotelOnAuth",(req,res)->{
          Hotel hotel=new Hotel();
          if(hotel.authenticated(req.queryParams("name"),req.queryParams("password"))){
            hotel.setName(req.queryParams("name"));
            hotel.setPassword(req.queryParams("password"));
            return om.writeValueAsString(hotel.addDataOnAuth());
          }
          return false;
        });
        post("/addOrder",(req,res)->{
            Order order=new Order();
            order.setPrice(Double.parseDouble(req.queryParams("price")));
            order.setWaiter(req.queryParams("waiter"));
            order.setHotel(req.queryParams("hotel"));
            if(order.save()){
                return  om.writeValueAsString(order);
            }
            return false;
        });
        post("/registerWaiter",(req,res)->{
           Waiter waiter=new Waiter();
           waiter.setName(req.queryParams("name"));
           waiter.setPassword(req.queryParams("password"));
           if(waiter.register()){
               return  om.writeValueAsString(waiter);
           }
           return false;
        });
        get("/waiterOnAuth",(req,res)->{
          Waiter waiter=new Waiter();
          if(waiter.authenticated(req.queryParams("name"),req.queryParams("password"))){
            waiter.setName(req.queryParams("name"));
            waiter.setPassword(req.queryParams("password"));
            return om.writeValueAsString(waiter.addDataOnAuth());
          }
          return false;
        });
        //Hotel
        post("/addCategory",(req,res)->{
          try{
            Category category=new Category();
            category.setName(req.queryParams("category"));
            category.setHotel(req.queryParams("hotel"));
            if(!category.isExisting()){
              if(category.save()){
                return om.writeValueAsString(category);
              }
            }
          }catch(Exception ex){
            System.out.println(ex.getMessage());
          }
          return false;
        });
        //Client Get Category
         get("/getCategory",(req,res)->{
           try{
              return om.writeValueAsString(Category.getCategory(req.queryParams("hotel")));
           }catch(Exception ex){
             System.out.println(ex.getMessage());
           }
           return 0;
        });
        post("/addFood",(req,res)->{
          try {

          }catch (Exception e) {
            System.out.println(e.getMessage());
          }
        });
    }
}
