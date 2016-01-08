import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }
  @ClassRule
    public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
        goTo("http://localhost:4567/");
        assertThat(pageSource()).contains("Do you need a change?");
    }

  @Test
    public void isALeapYear() {
    goTo("http://localhost:4567");
    fill("#sender").with("47");
    submit(".btn");
    assertThat(pageSource()).contains("1 quarter 2 dime 2 penny");
  }
}
