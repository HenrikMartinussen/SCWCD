package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

/**
 * hfsj p 514
 */
public class SimpleTagTest2 extends SimpleTagSupport {
  private static Logger log = Logger.getLogger(SimpleTagTest2.class);
  
  static {
    log.debug("Class SimpleTagTest2 loads");
  }

  public SimpleTagTest2(){
    log.debug("SimpleTagTest2 noArg constructor runs");
  }
  
  public void setJspContext(JspContext pc) {
    log.debug("SimpleTagTest2.setJspContext(JspContext) runs");
    super.setJspContext(pc);
  }

  public void setJspBody(JspFragment fragment){
    log.debug("SimpleTagTest2.setJspBody() runs");
    super.setJspBody(fragment);
  }

  public void setParent(JspTag parent) {
    log.debug("SimpleTagTest1.setParent(JspTag) runs");
    super.setParent(parent);
  }

  public void doTag() throws JspException, IOException {
    log.debug("SimpleTagTest2.doTag() runs");
    getJspBody().invoke(null); //Process the body of the tag and print it to the response. 
                               //The null argument means the output goes to the response 
                               //rather than some OTHER writer you pass in. 
  }
}

