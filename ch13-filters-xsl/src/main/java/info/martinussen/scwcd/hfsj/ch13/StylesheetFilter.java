package info.martinussen.scwcd.hfsj.ch13;

import info.martinussen.scwcd.hfsj.ch13.util.StylesheetCache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

/**
 * A utility class that uses the Servlet 2.4 Filtering API to apply
 * an XSLT stylesheet to a servlet response.
 *
 * @author Eric M. Burke
 */
public class StylesheetFilter implements Filter {

  private static Logger log = Logger.getLogger(StylesheetFilter.class);
  private FilterConfig config;
  private String xsltFileName;


  static {
    log.trace("StylesheetFilter is loaded");
  }

  public StylesheetFilter(){
    super();
    log.trace("StylesheetFilter is constructed");
  }


  public void init(FilterConfig config) 
      throws ServletException {
    log.debug("StylesheetFilter.init runs");
    this.config = config; //save for later reference
    String xsltPath = config.getInitParameter("xsltPath");
    if (xsltPath == null) {
      String message = "xsltPath is a required parameter. Please "
          + "check the deployment descriptor.";
      log.fatal(message);
      throw new UnavailableException(message);
    }
    log.debug("xsltPath: " + xsltPath);
    
    // convert the context-relative path to a physical path name
    this.xsltFileName = config.getServletContext().getRealPath(xsltPath);

    // verify that the file exists
    if (this.xsltFileName == null || !new File(this.xsltFileName).exists(  )) {
        String message = "Unable to locate stylesheet: " + this.xsltFileName;
        log.fatal(message);
        throw new UnavailableException(message, 30);//magic number?
    }
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
    byte[] origXML = responseWrapper.getBuffer();
    try {
      // do the XSLT transformation
      Transformer trans = StylesheetCache.newTransformer(this.xsltFileName);
      ByteArrayInputStream origXMLIn = new ByteArrayInputStream(origXML);
      Source xmlSource = new StreamSource(origXMLIn);
      ByteArrayOutputStream resultBuf = new ByteArrayOutputStream(  );
      trans.transform(xmlSource, new StreamResult(resultBuf));
      res.setContentLength(resultBuf.size(  ));
      res.setContentType("text/html");
      res.getOutputStream().write(resultBuf.toByteArray(  ));
      res.flushBuffer(  );
      
    } catch (TransformerException e) {
      throw new ServletException(e);
    }

  }

  public void destroy() {
    log.debug("StylesheetFilter.destroy runs");
    this.config = null;
    //do cleanup as necessary
  }
}
