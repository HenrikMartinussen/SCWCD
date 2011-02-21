package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * hfsj p 538
 * @author HMS
 *
 */
public class ClassicTagTest4 extends TagSupport{
  
  private String[] movies = {"Spiderman", "Saved!", "Amelie"};
  private int index = 0;

  
  public int doStartTag() throws JspException{
    return EVAL_BODY_INCLUDE;
  }
  
  public int doAfterBody() throws JspException{
    
    int returnValue = SKIP_BODY;
    if (index < movies.length) {
      pageContext.setAttribute("movie", movies[index]);
      index++;
      returnValue = EVAL_BODY_AGAIN;
    } else {
      returnValue = SKIP_BODY;
    }
    return returnValue;
  }
  
  public int doEndTag() throws JspException{
    return EVAL_PAGE;
  }
  
}
