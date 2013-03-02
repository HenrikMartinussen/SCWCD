package info.martinussen.scwcd.hfsj.ch13;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;

//Java and xslt p.316

/**
 * A custom servlet output stream that stores its data in a buffer,
 * rather than sending it directly to the client.
 *
 * @author Eric M. Burke
 */
public class BufferedServletOutputStream extends ServletOutputStream {
  
  private static Logger log = Logger.getLogger(BufferedServletOutputStream.class);
  
  static {
    log.trace("BufferedServletOutputStream was loaded");
  }
  
  //The actual buffer
  private ByteArrayOutputStream bos = new ByteArrayOutputStream();

  /**
   * @return the contents of the buffer
   */
  public byte[] getBuffer(){
    log.debug("BufferedServletOutputStream.getBuffer() was called");
    return this.bos.toByteArray();
  }
  
  @Override
  public void write(int data) throws IOException {
    this.bos.write(data);
  }
  
  //BufferedHttpResponseWrapper calls this method
  public void reset(){
    log.debug("BufferedServletOutputStream.reset() was called");
    this.bos.reset();
  }
  
  //BufferedHttpResponseWrapper calls this method
  public void setBufferSize(int size){
    log.debug("BufferedServletOutputStream.setBufferSize() was called - parameter size was: " + size);
    // no way to resize an existing ByteArrayOutputStream
    this.bos = new ByteArrayOutputStream(size);
  }

}
