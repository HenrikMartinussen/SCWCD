package info.martinussen.scwcd.hfsj.ch13.replace;

import info.martinussen.scwcd.hfsj.ch13.BufferedHttpResponseWrapper;

import java.io.IOException;
import java.util.List;

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
 * A utility class that uses the Servlet 2.4 Filtering API to replace
 * selected words in the response
 *
 */
public class ReplacingFilter implements Filter {


  private static Logger log = Logger.getLogger(ReplacingFilter.class);
  private FilterConfig config;
  private List<Rule> rules = null;

  static {
    log.trace("ReplacingFilter is loaded");
  }

  public ReplacingFilter(){
    super();
    log.trace("ReplacingFilter is constructed");
  }


  public void init(FilterConfig config) throws ServletException {
    log.debug("ReplacingFilter.init runs");
    this.config = config; //save for later reference
    Object o =  this.config.getServletContext().getAttribute("rules");
    if (o instanceof List<?>){
      rules = (List<Rule>) o;
    }
    if (rules == null) log.error("ReplacingFilter.init() - No Rules found") ;
  }

  public void doFilter(ServletRequest servletRequest, 
                       ServletResponse servletResponse, 
                       FilterChain filterChain) throws IOException, ServletException {
    if (!(servletRequest instanceof HttpServletRequest) ||
        !(servletResponse instanceof HttpServletResponse)){
      String message = "Filter " + config.getFilterName() + " only supports Http";
      log.fatal(message);
      throw new ServletException(message);
    }
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;

    //implementation which takes place before the filterchain executes

    log.debug(config.getFilterName() + " before target");
    BufferedHttpResponseWrapper responseWrapper = new BufferedHttpResponseWrapper(res);
    
    filterChain.doFilter(req, responseWrapper);    

    //implementation which takes place after the filterchain executes

    log.debug(config.getFilterName() + " after target");
    // do the replacing
    String origResponse  = new String (responseWrapper.getBuffer(),"UTF-8");
    
    String workResp = replace(origResponse, rules);
    
    byte[] modifiedResponse = workResp.getBytes("UTF-8");

    
    res.setContentLength(modifiedResponse.length);
    res.setContentType("text/html");
    res.getOutputStream().write(modifiedResponse);
    res.flushBuffer();
  }
  
  private String replace (String target, List<Rule> rules){
    String returnValue = null;
    if (target != null) {
      returnValue = new String(target);
      for (Rule rule : rules){
        returnValue =  returnValue.replace(rule.getToBeReplaced(), rule.getReplaceWith());
      }
    }
    return returnValue;
  } 

  public void destroy() {
    log.debug("ReplacingFilter.destroy runs");
    this.config = null;
    //do cleanup as necessary
  }
}


