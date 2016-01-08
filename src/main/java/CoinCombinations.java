import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class CoinCombinations {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String stringCoins= request.queryParams("sender");
      Integer coins = Integer.parseInt(stringCoins);

      String coinAmountStr= request.queryParams("coin");
      Integer coinAmount = Integer.parseInt(coinAmountStr);

      String dimesStr = request.queryParams("dime");
      Integer dimesAm = Integer.parseInt(dimesStr);

      String nikStr = request.queryParams("nickle");
      Integer nikAm = Integer.parseInt(nikStr);

      String penStr = request.queryParams("penny");
      Integer penAm = Integer.parseInt(penStr);

      String change;
      change = giveChange(coins, coinAmount, dimesAm, nikAm, penAm);

      model.put("blablabla", change);
      return new ModelAndView(model, layout);

      }, new VelocityTemplateEngine());

  }

  public static String giveChange(Integer numberInput, Integer quartersAmount, Integer dimesAmount, Integer nickelsAmount, Integer pennyAmount) {
    String result = "";
    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickels = 0;
    Integer penny = 0;
    String noPenny = "";
    while (numberInput > 0) {
      if (numberInput >= 25 && quarters < quartersAmount) {
        numberInput -= 25;
        quarters++;
      } else if (numberInput >= 10 && dimes < dimesAmount) {
        numberInput -= 10;
        dimes++;
      }else if (numberInput >= 5 && nickels < nickelsAmount) {
        numberInput -= 5;
        nickels++;
      } else if(numberInput >= 1 && penny < pennyAmount) {
        numberInput -= 1;
        penny++;
      }else {
        numberInput = 0;
        noPenny = "No more money ";
      }
    }
      String quarterStr = "";
      String dimeStr = "";
      String nickelStr = "";
      String pennyStr = "";

      if (quarters > 0) {
        quarterStr = quarters + " quarter";
      }
      if (dimes > 0) {
        dimeStr = " " + dimes + " dime";
      }
      if (nickels > 0) {
        nickelStr = " " + nickels + " nickel";
      }
      if (penny > 0) {
        pennyStr = " " + penny + " penny";
      }


      return result = String.format("%s%s%s%s%s", noPenny, quarterStr, dimeStr, nickelStr, pennyStr);
    }

}
