package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * hfsj p 514
 */
public class SimpleTagTest2 extends SimpleTagSupport {
  
  static {
    System.out.println("Class SimpleTagTest2 loads");
  }

  public SimpleTagTest2(){
    System.out.println("SimpleTagTest2 noArg constructor runs");
  }
  
  public void setJspContext(JspContext pc) {
    System.out.println("SimpleTagTest2.setJspContext(JspContext) runs");
    super.setJspContext(pc);
  }

  public void setJspBody(JspFragment fragment){
    System.out.println("SimpleTagTest2.setJspBody() runs");
    super.setJspBody(fragment);
  }

  public void setParent(JspTag parent) {
    System.out.println("SimpleTagTest1.setParent(JspTag) runs");
    super.setParent(parent);
  }

  public void doTag() throws JspException, IOException {
    System.out.println("SimpleTagTest2.doTag() runs");
    getJspBody().invoke(null); //Process the body of the tag and print it to the response. The null argument means the output goes to the response rather than some OTHER writer you pass in. 
  }
}

