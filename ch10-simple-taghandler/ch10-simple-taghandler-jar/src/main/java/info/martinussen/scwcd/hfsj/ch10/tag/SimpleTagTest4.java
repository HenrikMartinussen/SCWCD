package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest4 extends SimpleTagSupport{
  
  String[] movies = {"Monsoon Wedding", "Saved!", "Fahrenheit 9/11"};

  @Override
  public void doTag() throws JspException, IOException {
    for (int i = 0; i < movies.length; i++){
      getJspContext().setAttribute("movie", movies[i]);
      getJspBody().invoke(null);
    }
  }
  
  

}
