package info.martinussen.scwcd.hfsj.ch13.replace;

import info.martinussen.scwcd.hfsj.ch13.StringWrapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Generic modification filter that buffers the output and lets
 * doModification method change the output string before sending
 * it to the real output, i.e., the client. This is an abstract
 * class: you <I>must</I> override doModification in a subclass.
 * CSJP p. 238
 */
public abstract class ModificationFilter implements Filter {
  
  protected FilterConfig config;
  private HttpServletRequest request;
  private HttpServletResponse response;

  /** 
   * Classes extending from ModificationFilter must
   * override this method.
   */
  public abstract String doModification(String origResponse);

  @Override
  public void init(FilterConfig config) {
    // Save FilterConfig object for later use by subclasses
    this.config = config;
  }
  
  /** 
   * for potential use by the child class.
   */
  public HttpServletRequest getRequest() {
    return request;
  }

  /** 
   * for potential use by the child class.
   */
  public HttpServletResponse getResponse() {
    return response;
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
      throws IOException, ServletException  {

    request = (HttpServletRequest) req;
    response = (HttpServletResponse) resp;
    StringWrapper responseWrapper = new StringWrapper(response);

    // Invoke resource, accumulating output in the wrapper.
    chain.doFilter(request, responseWrapper);
    
    // Turn entire output into one big String.
    String modifiedResponse = doModification(responseWrapper.toString());
    
    // Send modified response to the client
    PrintWriter out = response.getWriter();
    out.write(modifiedResponse);
  }

  @Override
  public void destroy() { }
}
