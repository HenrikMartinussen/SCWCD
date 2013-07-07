package info.martinussen.keyfile;

import info.martinussen.keyfile.model.ProductKey;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class KeyFileServlet extends HttpServlet{
  
  private static Logger log = Logger.getLogger(KeyFileServlet.class);

  static {
    log.debug("KeyFileServlet class is loaded");
  }

  public KeyFileServlet(){
    super();
    log.debug("KeyFileServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    log.debug("doPost is called");
    
    ProductKey key = new ProductKeyBuilder().buildProductKey(req);
    
    String xmlKey = key.getKeyAsXmlString();
    log.debug("KeyFileServlet.doPost XmlKey: \r\n" + xmlKey);
    
    resp.setContentType("text/xml");
    resp.setContentLength(xmlKey.length());
    resp.setHeader("Content-Disposition",
                       " :attachment; filename=\"" + key.getSuggestedFileName(req) + "\""); 

    ServletOutputStream os = resp.getOutputStream();
    byte[] outBytes = xmlKey.getBytes();
    os.write(outBytes);
    log.trace("os.write finished");
    os.flush();
    log.trace("os.flush finished");
    os.close();
    log.trace("os.close finished");
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.debug("service is called");
    super.service(req, resp);
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    log.debug("init(ServletConfig) is called");
    super.init(config);
  }

  @Override
  public void init() throws ServletException {
    log.debug("init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    log.debug("destroy is called");
    super.destroy();
  }
}
