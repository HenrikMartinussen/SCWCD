package info.martinussen.scwcd.hfsj.ch10.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * hfsj p 538, 541
 * @author HMS
 *
 */
public class ClassicTagTest4 extends TagSupport{
  
  private String[] movies = {"Spiderman", "Saved!", "Amelie"};
  private int index; 
  
  public int doStartTag() throws JspException{
    index = 0; // classic tags might be reused, so instance variables must be reset for each invocation
    setMovie();
    return EVAL_BODY_INCLUDE;
  }

  public int doAfterBody() throws JspException{
    
    int returnValue = SKIP_BODY;
    if (index < movies.length) {
      setMovie();
      returnValue = EVAL_BODY_AGAIN;
    } else {
      returnValue = SKIP_BODY;
    }
    return returnValue;
  }
  
  public int doEndTag() throws JspException{
    return EVAL_PAGE;
  }

  private void setMovie() {
    pageContext.setAttribute("movie", movies[index]);
    index++;
  }
  
}

