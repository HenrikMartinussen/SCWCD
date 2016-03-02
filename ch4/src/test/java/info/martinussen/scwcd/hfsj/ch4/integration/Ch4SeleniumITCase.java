package info.martinussen.scwcd.hfsj.ch4.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ch4SeleniumITCase {
  
  private static final String SCHEME           = "http://";
  private static final String HOST_NAME        = "localhost";
  private static final String PORT             = "8081";
  private static final String RESOURCE_TO_OPEN = "ch4/";
  private static final String URL              = SCHEME + HOST_NAME + ":" + PORT + "/" + RESOURCE_TO_OPEN;


  private WebDriver webDriver;
  
  
  @Before
  public void setUp(){
    webDriver = new FirefoxDriver();
    webDriver.get(URL);
  }
  
  @After
  public void tearDown(){
    webDriver.quit();
  }

  @Test
  public void testCh4Amber() throws Exception {
    Select colorSelect = new Select(webDriver.findElement(By.name("color")));
    colorSelect.selectByVisibleText("amber");
    webDriver.findElement(By.tagName("input")).click();
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "try: Jack Amber\ntry: Red Moose"));
    //TODO make it an obvious assert
  }
  
  @Test
  public void testCh4Dark() throws Exception {
    Select colorSelect = new Select(webDriver.findElement(By.name("color")));
    colorSelect.selectByVisibleText("dark");
    webDriver.findElement(By.tagName("input")).click();
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "try: Jail Pale Ale\ntry: Gout Stout"));
  }
  
  @Test
  public void testCh4Light() throws Exception {
    Select colorSelect = new Select(webDriver.findElement(By.name("color")));
    colorSelect.selectByVisibleText("light");
    webDriver.findElement(By.tagName("input")).click();
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "try: Jail Pale Ale\ntry: Gout Stout"));
  }
  
  @Test
  public void testCh4Brown() throws Exception {
    Select colorSelect = new Select(webDriver.findElement(By.name("color")));
    colorSelect.selectByVisibleText("brown");
    webDriver.findElement(By.tagName("input")).click();
    WebDriverWait wait = new WebDriverWait(webDriver, 10);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "try: Jail Pale Ale\ntry: Gout Stout"));
  }
}
