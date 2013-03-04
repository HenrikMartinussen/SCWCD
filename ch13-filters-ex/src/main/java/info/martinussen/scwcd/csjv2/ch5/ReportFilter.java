package info.martinussen.scwcd.csjv2.ch5;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Core Servlets and JSP vol 2(csjv2), p 211
 * @author HMS
 *
 */
public class ReportFilter implements Filter{

  private static Logger log = Logger.getLogger(ReportFilter.class);

  static {
    log.debug("ReportFilter is loaded");
  }
  
  public ReportFilter(){
    super();
    log.debug("ReportFilter is constructed");
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;//response is not cast - it isn't used
    
    log.info(req.getRemoteHost()     + 
             " attempted to access " + 
             req.getRequestURL()     + 
             " on " + new Date());
    filterChain.doFilter(req, response);    
  }

  public void init(FilterConfig config) throws ServletException {
    log.debug("ReportFilter.init runs");//config is not saved - it isn't used
  }

  public void destroy() {
    log.debug("ReportFilter.destroy runs");
  }
}
