package info.martinussen.scwcd.hfsj.ch13;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * hfsj p 707
 * @author HMS
 *
 */
public class LoggingFilter implements Filter{

  private FilterConfig config;
  private static Logger log = Logger.getLogger(LoggingFilter.class);

  static {
    log.trace("LoggingFilter is loaded");
  }
  
  public LoggingFilter(){
    super();
    log.trace("LoggingFilter is constructed");
  }
  
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;

    //implementation which takes place before the filterchain executes
    
    log.info(config.getFilterName() + " before target");
    filterChain.doFilter(req, res);    
    
    //implementation which takes place after the filterchain executes
    
    log.info(config.getFilterName() + " after target");
  }

  public void init(FilterConfig config) throws ServletException {
    log.debug("LoggingFilter.init runs");
    this.config = config; //save for later reference
  }

  public void destroy() {
    log.debug("LoggingFilter.destroy runs");
    //do cleanup as necessary
  }
}
