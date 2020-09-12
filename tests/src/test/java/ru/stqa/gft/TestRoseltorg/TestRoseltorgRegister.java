package ru.stqa.gft.TestRoseltorg;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRoseltorgRegister {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRoseltorgRegister() throws Exception {
    driver.get("https://yandex.ru/");
    driver.findElement(By.id("text")).clear();
    driver.findElement(By.id("text")).sendKeys("росэлторг");
    driver.findElement(By.id("text")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("text")).clear();
    driver.findElement(By.id("text")).sendKeys("росэлторг");
    driver.findElement(By.id("uniq442250")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    driver.findElement(By.cssSelector("button.auth-menu__btn.auth-menu__btn--register.js-register-popup-link")).click();
    driver.findElement(By.linkText("Поставщик")).click();
    driver.findElement(By.linkText("Единая аккредитация для участия в корпоративных закупках и закупках субъектов 223-ФЗ, аккредитация иностранных поставщиков (в том числе для регистрации в ЕРУЗ)")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  
}
