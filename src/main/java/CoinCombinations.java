import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class CoinCombinations {
  public static void main(String[] args) {}
    public static String giveChange(Integer numberInput) {
      String result = "";
      Integer quarters = 0;
      Integer dimes = 0;
      while (numberInput > 0) {
        if (numberInput >= 25) {
          numberInput -= 25;
          quarters++;
        } else if (numberInput >= 10){
          numberInput -= 10;
          dimes++;
        }
      }
      if (quarters > 0) {
        result = quarters + " quarter";
      }
      if (dimes > 0) {
        result = result + " " + dimes + " dime";
      }


      return result;
    }

}
