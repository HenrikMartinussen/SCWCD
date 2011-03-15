package info.martinussen.scwcd.csjv2.ch5;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Core Servlets and JSP vol 2(csjv2), p 217-220
 * @author HMS
 *
 */
public class LogFilter implements Filter{

  private static Logger log = Logger.getLogger(LogFilter.class);

  static {
    log.debug("LogFilter is loaded");
  }

  private FilterConfig filterConfig;
  private ServletContext servletContext;
  private String filterName;
  
  public LogFilter(){
    super();
    log.debug("LogFilter is constructed");
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;//response is not cast - it isn't used
    String logMessage = req.getRemoteHost()        + 
                        " attempted to access "    + 
                        req.getRequestURL()        + 
                        " on " + new Date() + ". " + 
                        "(Reported by " + filterName + ")";
    
    log.info(logMessage);
    servletContext.log(logMessage);
    filterChain.doFilter(req, response);    
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    log.debug("LogFilter.init runs");
    this.filterConfig = filterConfig;
    servletContext = this.filterConfig.getServletContext();
    filterName = this.filterConfig.getFilterName();
  }

  public void destroy() {
    log.debug("LogFilter.destroy runs");
  }
}
