package info.martinussen.keyfile;

import info.martinussen.keyfile.model.ProductKey;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
    String version = req.getParameter("version");
    int clientCount = Integer.parseInt(req.getParameter("clientCount"));
    int automatCount = Integer.parseInt(req.getParameter("automatCount"));
    String tiltEnabledStr = req.getParameter("tiltEnabled");
    boolean tiltEnabled = tiltEnabledStr != null && tiltEnabledStr.equals("on");
    
    String liftEnabledStr = req.getParameter("liftEnabled");
    boolean liftEnabled = liftEnabledStr != null && liftEnabledStr.equals("on");
    log.debug("Request parameter version: " + version);
    log.debug("Request parameter clientCount: " + clientCount);
    log.debug("Request parameter automatCount: " + automatCount);
    log.debug("Request parameter tiltEnabled: " + tiltEnabled);
    log.debug("Request parameter liftEnabled: " + liftEnabled);
//    log.debug("Request parameter tiltEnabled: " + req.getParameter("tiltEnabled"));
//    log.debug("Request parameter liftEnabled: " + req.getParameter("liftEnabled"));
    ProductKey key = new ProductKey();
    key.setVersion(version);
    key.setClientCount(clientCount);
    key.setAutomatCount(automatCount);
    key.setTiltEnabled(tiltEnabled);
    key.setLiftEnabled(liftEnabled);
    
    String xmlKey = key.getKeyAsXmlString();
    log.debug("XmlKey: " + xmlKey);
    
    resp.setContentType("text/xml");
    resp.setHeader("Content-Disposition",
                       "attachment;filename=keyFile.xml");

    OutputStream os = resp.getOutputStream();
    byte[] outBytes = xmlKey.getBytes();
    os.write(outBytes);
    os.flush();
    os.close();
    
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
