import org.junit.*;
import static org.junit.Assert.*;

public class CoinCombinationsTest {

  @Test
  public void coinCombinations_Enter25_Return1Quarter() {
    CoinCombinations coinCombinations = new CoinCombinations();
    assertEquals("1 quarter", coinCombinations.giveChange(25));

    }

  @Test
  public void coinCombinations_Enter35_Return1Quarter_1Dime() {
    CoinCombinations coinCombinations = new CoinCombinations();
    assertEquals("1 quarter 1 dime", coinCombinations.giveChange(35));
  }

  @Test
  public void coinCombinations_Enter40_Return1Quarter_1Dime_1Nickel() {
    CoinCombinations coinCombinations = new CoinCombinations();
    assertEquals("1 quarter 1 dime 1 nickel", coinCombinations.giveChange(40));
  }
}

 /*rock Scissors true
Scissors Rock  false
rock paper false
Paper Rock true
scissors paper true
paper scissors false
*/
