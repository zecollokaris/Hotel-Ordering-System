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
        get("/",(req,res)->{
          return  "Hello World";
        });
        get("/getHotelList",(req,res)->{
          return om.writeValueAsString(Hotel.getHotels());
        });
    }
}
