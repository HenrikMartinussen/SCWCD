package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * hfsj p 532
 */
public class ClassicTagTest2 extends TagSupport {
  
  static {
    System.out.println("Class ClassicTagTest2 loads");
  }

  private JspWriter out;

  public ClassicTagTest2(){
    System.out.println("ClassicTagTest2 noArg constructor runs");
  }

  @Override
  public int doStartTag() throws JspException {
    out = pageContext.getOut();
    try {
      out.println("in ClassicTagTest2 doStartTag()");
    } catch(IOException ex) {
       throw new JspException("IOException- " + ex. toString());
    }
    return SKIP_BODY; //This says, "Don’t evaluate the body if there is one just go straight to the doEndTag() method."
  }
  
  @Override
  public int doEndTag() throws JspException {
    try {
      out.println("in ClassicTagTest2 doEndTag()");
    } catch(IOException ex) {
       throw new JspException("IOException- " + ex.toString());
    }
    return EVAL_PAGE; //This says, “Evaluate the rest of the page” (as opposed to SKIP_PAGE, which would be just like  throwing a SkipPageException from a Simple Taghandler).
  }

  
  
}

