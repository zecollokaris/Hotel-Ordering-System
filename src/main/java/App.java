import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import static spark.Spark.*;
import spark.Filter;
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

        after((Filter)(req,res)->{
          res.header("Access-Control-Allow-Origin", "*");
          res.header("Access-Control-Allow-Methods", "GET,POST");
          res.header("Access-Control-Allow-Credentials", "true");
          res.status(200);
        });
        get("/getHotelList",(req,res)->{
          return om.writeValueAsString(Hotel.getHotels());
        });
        post("/registerHotel",(req,res)->{
          res.status(200);
          Hotel hotel=new Hotel();
          hotel.setName(req.queryParams("name"));
          hotel.setPassword(req.queryParams("password"));
          if(hotel.register()){
              return  om.writeValueAsString(hotel);
          }
          return false;
        });
        get("/hotelOnAuth",(req,res)->{
          res.status(200);
          Hotel hotel=new Hotel();
          if(hotel.authenticated(req.queryParams("name"),req.queryParams("password"))){
            hotel.setName(req.queryParams("name"));
            hotel.setPassword(req.queryParams("password"));
            return om.writeValueAsString(hotel.addDataOnAuth());
          }
          return false;
        });
        post("/addOrder",(req,res)->{
            res.status(200);
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
           res.status(200);
           Waiter waiter=new Waiter();
           waiter.setName(req.queryParams("name"));
           waiter.setPassword(req.queryParams("password"));
           if(waiter.register()){
               return  om.writeValueAsString(waiter);
           }
           return false;
        });
        get("/waiterOnAuth",(req,res)->{
          res.status(200);
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
            res.status(200);
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
           res.status(200);
           try{
              return om.writeValueAsString(Category.getCategory(req.queryParams("hotel")));
           }catch(Exception ex){
             System.out.println(ex.getMessage());
           }
           return 0;
        });
        post("/addFood",(req,res)->{
          res.status(200);
          try {
            Food food=new Food();
            food.setName(req.queryParams("name"));
            food.setPrice(Double.parseDouble(req.queryParams("price")));
            food.setHotel(req.queryParams("hotel"));
            if(food.save()){
              if(food.addToMenu(Integer.parseInt(req.queryParams("catID")))){
                  return om.writeValueAsString(food);
              }
            }
          }catch (Exception e) {
            System.out.println(e.getMessage());
          }
          return false;
        });
        get("/getFoods",(req,res)->{
          res.status(200);
          try {
            return om.writeValueAsString(Food.getFoods(req.queryParams("hotel"),Integer.parseInt(req.queryParams("catID"))));
          }catch(Exception ex){
            System.out.println(ex.getMessage());
          }
          return 0;
        });
    }
}
