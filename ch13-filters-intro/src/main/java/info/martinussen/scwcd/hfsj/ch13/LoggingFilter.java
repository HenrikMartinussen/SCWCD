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

/**
 * hfsj p 707
 * @author HMS
 *
 */
public class LoggingFilter implements Filter{

  private FilterConfig config;

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    //implementation which takes place before the filterchain executes
    System.out.println(config.getFilterName() + " before target");
    filterChain.doFilter(req, res);    
    //implementation which takes place after the filterchain executes
    System.out.println(config.getFilterName() + " after target");
  }

  public void init(FilterConfig config) throws ServletException {
    this.config = config; //save for later reference
  }

  public void destroy() {
    //do cleanup as necessary
  }
}
