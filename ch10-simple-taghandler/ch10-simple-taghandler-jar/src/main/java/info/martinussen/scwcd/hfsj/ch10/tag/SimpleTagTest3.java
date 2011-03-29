package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

public class SimpleTagTest3 extends SimpleTagSupport{
  private static Logger log = Logger.getLogger(SimpleTagTest3.class);

  
  
  @Override
  public void setJspBody(JspFragment jspBody) {
    log.debug("SimpleTagTest3.setJspBody() runs");
    super.setJspBody(jspBody);
  }



  @Override
  public void setJspContext(JspContext pc) {
    log.debug("SimpleTagTest3.setJspContext(JspContext) runs");
    super.setJspContext(pc);
  }



  @Override
  public void setParent(JspTag parent) {
    log.debug("SimpleTagTest3.setParent()  runs");
    super.setParent(parent);
  }



  @Override
  public void doTag() throws JspException, IOException {
    getJspContext().setAttribute("message", "Wear sunscreen.");
    log.debug("SimpleTagTest3.doTag() runs");
    getJspBody().invoke(null);
  }
}
