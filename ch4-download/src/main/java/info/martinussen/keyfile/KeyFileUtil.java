package info.martinussen.keyfile;

public class KeyFileUtil {
  
  public static String to5chars(String numberString) {
    String returnValue = null;
    int len = numberString.length();
    if(len > 5){
      returnValue = numberString.substring(len - 5, len - 1); //last 5 chars (digits)
    } else {
      returnValue = numberString;
      if (len < 5) {
        for (int i = 0; i < len; i++){ //prepend with "0"'s until length is 5
          returnValue = "0" + returnValue;
        }
      } else {
        //nothing - length was apparently 5 and returnValue has already been assigned the value of the input parameter numberString
      } 
    }
    return numberString;
  }

  public static void main (String[] args){
    String test1  = "12345";
    String test2 = "1234";
    String test3 = "123456";
    String test4 = "5";
    
    System.out.println(to5chars(test1).length());
    System.out.println(to5chars(test2).length());
    System.out.println(to5chars(test3).length());
    System.out.println(to5chars(test4).length());
    
    assert false==true;
    assert to5chars(test1).length() == 5;
    assert to5chars(test2).length() == 5;
    assert to5chars(test3).length() == 5;
    assert to5chars(test4).length() == 5;
    
    assert to5chars(test1).equals("12345");
    assert to5chars(test2).equals("01234");
    assert to5chars(test3).equals("23456");
    assert to5chars(test4).equals("00005");
    
    System.out.println("OK");
  }

}
