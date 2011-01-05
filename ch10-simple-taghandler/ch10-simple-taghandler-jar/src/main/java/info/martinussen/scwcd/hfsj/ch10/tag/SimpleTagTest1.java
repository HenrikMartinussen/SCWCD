package info.martinussen.scwcd.hfsj.ch10.tag;

/**
 * hfsj p 513
 */
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest1 extends SimpleTagSupport {
  
  
  public void doTag() throws JspException, IOException {
    getJspContext().getOut().print(getStatement() + "<br/>");
  }
  
  private String getStatement(){
    String statement;
    String[] statements = {"This is the lamest use of a custom ta", "How lame is this", "How come the tall girl in the book is always so negative"};
    int random = (int) (Math.random() * statements.length);
    statement = statements[random];
    return statement;
  }

}
