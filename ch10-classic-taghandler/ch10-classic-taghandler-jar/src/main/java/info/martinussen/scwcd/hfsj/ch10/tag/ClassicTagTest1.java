package info.martinussen.scwcd.hfsj.ch10.tag;

/**
 * Classic Tags
 * hfsj p 531
 */
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ClassicTagTest1 extends TagSupport {
  
  static {
    System.out.println("Class ClassicTagTest1 loads");
  }
  
  public ClassicTagTest1(){
    System.out.println("ClassicTagTest1 noArg constructor runs");
  }

  public int doStartTag() throws JspException{
    JspWriter out = pageContext.getOut();
    try {
      out.println("classic tag output says:");
      out.println(getStatement());
    } catch (IOException e) {
      throw new JspException("IOException- " + e.toString());
    }
    return 42;
  }
  
  /**
   * selects at random, and returns, one of the statements in the 
   * statements array
   * @return Statement String
   */
  private String getStatement(){
    String statement;
    String[] statements = {"This is the lamest use of a custom tag", 
                           "This is sooo lame",
                           "Wickedly Smart - NOT",
                           "How lame is this", 
                           "How come the tall girl in the book is always so negative"};
    int random = (int) (Math.random() * statements.length);
    statement = statements[random];
    return statement;
  }

}
