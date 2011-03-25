package info.martinussen.scwcd.hfsj.ch12;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Class for establishing a pseudo database of user comments on startup
 * @author HMS
 *
 */
public class ContextListener implements ServletContextListener{

  List<String> comments;
  
  public void contextDestroyed(ServletContextEvent event) {
    comments = null;
  }

  public void contextInitialized(ServletContextEvent event) {
    comments =  new ArrayList<String>();
    comments.add("This site rocks.");
    comments.add("This site is cool.");
    comments.add("This site is stupid.");
    event.getServletContext().setAttribute("commentList", comments);
    System.out.println("contextInitialized");
  }

}
