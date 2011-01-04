package info.martinussen.scwcd.hfsj.ch9.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdvisorTagHandler extends SimpleTagSupport {
  
  private String user = null;
  
  public void doTag() throws JspException, IOException {
    getJspContext().getOut().write("Hello " + user + "<br/>");
    getJspContext().getOut().write("Your advice is: " + getAdvice());
  }
  
  public void setUser(String user){
    this.user = user;
  }
  
  private String getAdvice(){
    String advice;
    String[] advices = {"That color's not working for you.", "You should call in sick.", "You might want to rethink that haircut."};
    int random = (int) (Math.random() * advices.length);
    advice = advices[random];
    return advice;
  }

}
