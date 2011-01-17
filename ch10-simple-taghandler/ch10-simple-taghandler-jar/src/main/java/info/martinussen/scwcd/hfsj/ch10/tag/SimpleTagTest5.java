package info.martinussen.scwcd.hfsj.ch10.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class SimpleTagTest5 extends SimpleTagSupport {

  @SuppressWarnings("unchecked")
  private List movieList;
  
  @SuppressWarnings("unchecked")
  public void setMovieList(List movieList) {
    this.movieList = movieList;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void doTag() throws JspException, IOException {
    Iterator it = movieList.iterator();
    while (it.hasNext()){
      Movie movie = (Movie) it.next();
//      String movieTitle = (String) it.next();
//      Movie movie = new Movie(movieTitle, "Unknown");
      getJspContext().setAttribute("movie", movie);
      getJspBody().invoke(null);
    }
  }
}
