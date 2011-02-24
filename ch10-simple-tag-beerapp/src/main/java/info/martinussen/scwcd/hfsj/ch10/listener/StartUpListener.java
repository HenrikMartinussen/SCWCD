package info.martinussen.scwcd.hfsj.ch10.listener;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUpListener implements ServletContextListener{

  ServletContext context = null;
  
  public void contextInitialized(ServletContextEvent event) {
    System.out.println("in contextInitialized");
    context = event.getServletContext();
    List<String> colors = new ArrayList<String>();
    colors.add("light");
    colors.add("amber");
    colors.add("brown");
    colors.add("dark");
    colors.add("pink");
    context.setAttribute("colorList", colors);
  }

  public void contextDestroyed(ServletContextEvent event) {
    System.out.println("in contextDestroyed");
  }


}
