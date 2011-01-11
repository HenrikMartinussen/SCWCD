package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest3 extends SimpleTagSupport{

  @Override
  public void doTag() throws JspException, IOException {
    getJspContext().setAttribute("message", "Wear sunscreen.");
    getJspBody().invoke(null);
    
    super.doTag();
  }
  

}
