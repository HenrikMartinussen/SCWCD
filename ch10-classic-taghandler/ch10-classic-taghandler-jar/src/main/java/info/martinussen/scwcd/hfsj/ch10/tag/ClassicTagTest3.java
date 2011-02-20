package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class ClassicTagTest3 extends TagSupport{

  private JspWriter out;

  @Override
  public int doStartTag() throws JspException {

    out = pageContext.getOut();
    
    try {
      out.println("in ClassicTagTest3 doStartTag() <br/>");
      out.println("Before body.") ;
    } catch(IOException ex) {
       throw new JspException("IOException- " + ex.toString()); 
    }
    return EVAL_BODY_INCLUDE;//THIS is what causes the body to be evaluated in a Classic tag handler!
  }

  @Override
  public int doEndTag() throws JspException {
    try {
      out.println("in ClassicTagTest3 doEndTag() <br/>");
      out.println("After body. ") ;
    } catch(IOException ex) {
       throw new JspException("IOException- " + ex. toString());
    }
    return EVAL_PAGE;
  }


  

}
