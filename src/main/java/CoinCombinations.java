import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class CoinCombinations {
  public static void main(String[] args) {}
    public static String giveChange(Integer numberInput) {
      String result;
      result = Integer.toString(numberInput / 25) + " quarter";
      return result;
    }

}
