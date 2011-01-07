package info.martinussen.scwcd.hfsj.ch10.tag;

/**
 * hfsj p 513
 */
import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest1 extends SimpleTagSupport {
  
  private String user;

  static {
    System.out.println("Class SimpleTagTest1 loads");
  }
  
  public SimpleTagTest1(){
    System.out.println("SimpleTagTest1 noArg constructor runs");
  }
  
  /**
   * This gives the handler a reference to a PageContext (a subclass of JspContext)
   */
  public void setJspContext(JspContext pc) {
    System.out.println("SimpleTagTest1.setJspContext(JspContext) runs");
    super.setJspContext(pc);
  }
  
  /**
   * This method is called if th tag i NOT declared to have a <body-content> 
   * of empty, AND the tag has a body.<br/>
   * If the tag has a body, the body comes in through this method. as an 
   * instance of JspFragment.
   */
  public void setJspBody(JspFragment fragment){
    System.out.println("SimpleTagTest1.setJspBody() runs");
    super.setJspBody(fragment);
    
  }

  /**
   * If the tag is nested (invoked from within another tag), this method is called. 
   */
  public void setParent(JspTag parent) {
    System.out.println("SimpleTagTest1.setParent(JspTag) runs");
    super.setParent(parent);
  }

  /**
   * Implementation of this tags behavior
   */
  public void doTag() throws JspException, IOException {
    System.out.println("SimpleTagTest1.doTag() runs");
    getJspContext().getOut().print(user + ": " + getStatement() + "<br/>");
  }
  
  public void setUser(String user){
    System.out.println("SimpleTagTest1.setUser(String) runs - parameter user was " + user);
    this.user = user;
  }
  
  /**
   * selects and returns one of the statements in the statements in the statements array
   * @return
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
