package info.martinussen.scwcd.hfsj.ch4.integration;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.*;



public class ch4Test extends SeleneseTestCase {
  
  
  @Before
  public void setUp(){
    this.selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8081");
    this.selenium.start();
  }
  
  @Test
  public void testCh4Amber() throws Exception {
    selenium.open("/ch4/");
    selenium.select("color", "label=amber");
    selenium.click("//input[@type='SUBMIT']");
    selenium.waitForPageToLoad("30000");
    verifyTrue(selenium.isTextPresent("exact:try: Jack Amber\ntry: Red Moose")); //defined in SeleneseTestCase
  }
  
  @Test
  public void testCh4Dark() throws Exception {
    selenium.open("/ch4/");
    selenium.select("color", "label=dark");
    selenium.click("//input[@type='SUBMIT']");
    selenium.waitForPageToLoad("30000");
    verifyTrue(selenium.isTextPresent("exact:try: Jail Pale Ale\ntry: Gout Stout")); //defined in SeleneseTestCase
  }
  
  @Test
  public void testCh4Light() throws Exception {
    selenium.open("/ch4/");
    selenium.select("color", "label=light");
    selenium.click("//input[@type='SUBMIT']");
    selenium.waitForPageToLoad("30000");
    verifyTrue(selenium.isTextPresent("exact:try: Jail Pale Ale\ntry: Gout Stout")); //defined in SeleneseTestCase
  }
  
  @Test
  public void testCh4Brown() throws Exception {
    selenium.open("/ch4/");
    selenium.select("color", "label=brown");
    selenium.click("//input[@type='SUBMIT']");
    selenium.waitForPageToLoad("30000");
    verifyTrue(selenium.isTextPresent("exact:try: Jail Pale Ale\ntry: Gout Stout")); //defined in SeleneseTestCase
  }
  
  @After
  public void tearDown(){
    this.selenium.stop();
  }


}
