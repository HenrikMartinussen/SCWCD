package info.martinussen.keyfile;

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

public class AuditLoggingFilter implements Filter {
  private static Logger log = Logger.getLogger(AuditLoggingFilter.class);

  static {
    log.debug("AuditLoggingFilter is loaded");
  }

  private FilterConfig filterConfig;
  private ServletContext servletContext;
  private String filterName;



  public AuditLoggingFilter() {
    super();
    log.debug("AuditLoggingFilter is constructed");
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    log.debug("AuditLoggingFilter.init runs");
    this.filterConfig = filterConfig;
    this.servletContext = this.filterConfig.getServletContext();
    this.filterName = this.filterConfig.getFilterName();
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    String logMessage = req.getRemoteHost()        + 
        " attempted to access "    + 
        req.getRequestURL()        + 
        " on " + new Date() + ". " + 
        "(Reported by " + filterName + ")";

    log.info(logMessage);
    servletContext.log(logMessage);
    chain.doFilter(req, response);   

  }

  public void destroy() {
    log.debug("AuditLoggingFilter is destroyed");
  }
}
