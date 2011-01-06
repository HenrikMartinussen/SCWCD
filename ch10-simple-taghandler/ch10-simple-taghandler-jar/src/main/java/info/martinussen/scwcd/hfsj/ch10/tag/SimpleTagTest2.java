package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest2 extends SimpleTagSupport {
  
  public void doTag() throws JspException, IOException {
    getJspBody().invoke(null); //Process the body of the tag and print it to the response. The null argument means the output goes to the response rather than some OTHER writer you pass in. 
  }
}

