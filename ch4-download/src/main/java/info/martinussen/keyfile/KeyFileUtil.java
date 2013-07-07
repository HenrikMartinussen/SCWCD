package info.martinussen.keyfile;

import org.apache.log4j.Logger;

public class KeyFileUtil {
  
  private static Logger log = Logger.getLogger(KeyFileUtil.class);
  
  public static String to5chars(String numberString) {
    String returnValue = null;
    int len = numberString.length();
    if(len > 5){
      returnValue = numberString.substring(len - 5, len); //last 5 chars (digits)
    } else {
      returnValue = numberString;
      if (len < 5) {
        for (int i = len; i < 5; i++){ //prepend with "0"'s until length is 5
          returnValue = "0" + returnValue;
        }
      } else {
        //nothing - length was apparently 5 and returnValue has already been assigned the value of the input parameter numberString
      } 
    }
    return returnValue;
  }

  /** Replaces characters that have special HTML meanings
   *  with their corresponding HTML character entities.
   */
  /*  Note that Javadoc is not used for the more detailed
      documentation due to the difficulty of making the
      special chars readable in both plain text and HTML.

      Given a string, this method replaces all occurrences of
      '<' with '&lt;', all occurrences of '>' with
      '&gt;', and (to handle cases that occur inside attribute
      values), all occurrences of double quotes with
      '&quot;' and all occurrences of '&' with '&amp;'.
      Without such filtering, an arbitrary string
      could not safely be inserted in a Web page.
   */
  public static String filterNonXmlChars(String input) {
    if (!hasNonXmlChars(input)) {
      return(input);
    }
    StringBuffer filtered = new StringBuffer(input.length());
    char c;
    for(int i=0; i<input.length(); i++) {
      c = input.charAt(i);
      switch(c) {
      case '<': filtered.append("&lt;"); break;
      case '>': filtered.append("&gt;"); break;
      case '"': filtered.append("&quot;"); break;
      case '&': filtered.append("&amp;"); break;
      //        case 'æ': filtered.append("&aelig;"); break;
      //        case 'Æ': filtered.append("&Aelig;"); break;
      //        case 'ø': filtered.append("&oslash;"); break;
      //        case 'Ø': filtered.append("&Oslash;"); break;
      //        case 'å': filtered.append("&aring;"); break;
      //        case 'Å': filtered.append("&Aring;"); break;
      default: filtered.append(c);
      }
    }
    if (input.length() != filtered.length()){
      log.info("KeyFileUtil.filter changed " + input + " into " + filtered.toString());
    }
    return(filtered.toString());
  }

  private static boolean hasNonXmlChars(String input) {
    boolean hasSpecialChars = false;
    if ((input != null) && (input.length() > 0)) {
      char c;
      for(int i=0; i<input.length(); i++) {
        c = input.charAt(i);
        switch(c) {
        //          case 'æ': hasSpecialChars = true; break;
        //          case 'Æ': hasSpecialChars = true; break;
        //          case 'ø': hasSpecialChars = true; break;
        //          case 'Ø': hasSpecialChars = true; break;
        //          case 'å': hasSpecialChars = true; break;
        //          case 'Å': hasSpecialChars = true; break;
        case '&': hasSpecialChars = true; break;
        case '<': hasSpecialChars = true; break;
        case '>': hasSpecialChars = true; break;
        case '"': hasSpecialChars = true; break;
        }
      }
    }
    return(hasSpecialChars);
  }

  public static String numericFilter(String numberString) {
    StringBuilder builder = new StringBuilder();
    char[] chars = numberString.toCharArray();
    for (char c : chars){
      if (c >= '0' && c <= '9' ) {
        builder.append(c);
      }
    }
    if (numberString.length() != builder.length()){
      log.info("ProductKeyBuilder.numericFilter changed " + numberString + " into " + builder.toString());
    }
    return builder.toString();
  }


  public static void assertNotNull(Object o){
    if (o == null) {throw new IllegalStateException("Unexpected null value");}
  }
  
}
