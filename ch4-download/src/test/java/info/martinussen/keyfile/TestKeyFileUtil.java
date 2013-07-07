package info.martinussen.keyfile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKeyFileUtil {

  @Test
  public void testAlreadyCorrectLength() {
    String test1  = "12345";
    assertTrue(KeyFileUtil.to5chars(test1).length()==5);
    assertTrue(KeyFileUtil.to5chars(test1).equals("12345"));
  }
  
  @Test
  public void testOneShortGetsOneZeroPrepended() {
    String test2 = "1234";
    assertTrue(KeyFileUtil.to5chars(test2).length()==5);
    assertTrue(KeyFileUtil.to5chars(test2).equals("01234"));
  }
  
  @Test
  public void testOneTooLongGetsCutTo5() {
    String test3 = "123456";
    assertTrue(KeyFileUtil.to5chars(test3).length()==5);
    assertTrue(KeyFileUtil.to5chars(test3).equals("23456"));
  }
  
  @Test
  public void testSingleDigitGets4PrependedZeros() {
    String test4 = "5";
    assertTrue(KeyFileUtil.to5chars(test4).length()==5);
    assertTrue(KeyFileUtil.to5chars(test4).equals("00005"));
  }
  
  @Test
  public void testThreeDigitsGets2PrependedZeros() {
    String test5 = "005";
    
    assertTrue(KeyFileUtil.to5chars(test5).length()==5);
    
    assertTrue(KeyFileUtil.to5chars(test5).equals("00005"));
    
  }
  

}
