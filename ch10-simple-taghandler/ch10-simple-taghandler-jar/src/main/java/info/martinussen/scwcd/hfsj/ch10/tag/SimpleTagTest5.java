package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class SimpleTagTest5 extends SimpleTagSupport {

  private List movieList;
  
  public void setMovieList(List movieList) {
    this.movieList = movieList;
  }

  @Override
  public void doTag() throws JspException, IOException {
    Iterator it = movieList.iterator();
    while (it.hasNext()){
      Movie movie = (Movie) it.next();
      getJspContext().setAttribute("movie", movie);
      getJspBody().invoke(null);
      
    }
  }
  
  

}
