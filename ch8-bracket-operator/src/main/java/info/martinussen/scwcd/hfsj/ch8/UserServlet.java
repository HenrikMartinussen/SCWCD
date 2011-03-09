package info.martinussen.scwcd.hfsj.ch8;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * HFSJ p 376, 378
 * @author henmar
 *
 */
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet{
  
  static Logger log = Logger.getLogger(UserServlet.class);

  static {
    log.debug("UserServlet class is loaded");
  }

  public UserServlet(){
    super();
    log.debug("UserServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    log.debug("doPost is called");
    
    Map<String, String> musicMap = new HashMap<String, String>();
    musicMap.put("Ambient", "Zero 7");
    musicMap.put("Surf", "Tahiti 80");
    musicMap.put("DJ", "BT");
    musicMap.put("Indie", "Nephew");
    req.setAttribute("musicMap", musicMap);
    
    req.setAttribute("Genre", "Ambient");
    
    //http://www.exampledepot.com/egs/java.util/coll_GetArrayFromVector.html
    String[] musicTypes = musicMap.keySet().toArray(new String[1]);
    Arrays.sort(musicTypes);
    req.setAttribute("MusicType", musicTypes);
    
    
    
    
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");//removed a forward slash...
    view.forward(req, resp);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.debug("service is called");
    super.service(req, resp);
  }

  @Override
  public void init() throws ServletException {
    log.debug("init is called");
    super.init();
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    log.debug("init(ServletConfig) is called");
    super.init(config);
  }

  @Override
  public void destroy(){
    log.debug("destroy is called");
    super.destroy();
  }
}
