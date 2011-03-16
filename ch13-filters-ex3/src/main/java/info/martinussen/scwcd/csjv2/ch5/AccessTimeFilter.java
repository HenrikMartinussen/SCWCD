package info.martinussen.scwcd.csjv2.ch5;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Core Servlets and JSP vol 2(csjv2), p 223
 * Filter which logs access at a level which depends on the actual 
 * time and the boundaries specified in web.xml
 * @author HMS
 *
 */
public class AccessTimeFilter implements Filter{

  private static Logger log = Logger.getLogger(AccessTimeFilter.class);

  static {
    log.debug("LogFilter is loaded");
  }

  private FilterConfig filterConfig;
  private ServletContext servletContext;
  private String filterName;
  private Date attentionTimeBegin;
  private Date attentionTimeEnd;
  
  public AccessTimeFilter(){
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
    
    log.debug(logMessage);
    servletContext.log(logMessage);
    filterChain.doFilter(req, response);    
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    log.debug("LogFilter.init runs");
    this.filterConfig = filterConfig;
    servletContext = this.filterConfig.getServletContext();
    filterName = this.filterConfig.getFilterName();
    
    String attentionTimeBeginString = this.filterConfig.getInitParameter("attentionTimeBegin");
    String attentionTimeEndString = this.filterConfig.getInitParameter("attentionTimeEnd");
    DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    try {
      attentionTimeBegin = (Date)formatter.parse(attentionTimeBeginString);
      attentionTimeEnd = (Date)formatter.parse(attentionTimeEndString);
    } catch (ParseException e) {
      log.error("Couldn't parse attentionTimeSpan filter init parameter", e);
      
    }

    log.info("attentionTimeBegin = " + attentionTimeBegin);
    log.info("attentionTimeEnd = " + attentionTimeEnd);
  }

  public void destroy() {
    log.debug("LogFilter.destroy runs");
  }
}
