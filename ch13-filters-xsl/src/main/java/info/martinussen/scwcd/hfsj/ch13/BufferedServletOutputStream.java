package info.martinussen.scwcd.hfsj.ch13;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

//Java and xslt p.316

/**
 * A custom servlet output stream that stores its data in a buffer,
 * rather than sending it directly to the client.
 *
 * @author Eric M. Burke
 */
public class BufferedServletOutputStream extends ServletOutputStream {
  
  private ByteArrayOutputStream bos = new ByteArrayOutputStream();

  public byte[] getBuffer(){
    return this.bos.toByteArray();
  }
  
  @Override
  public void write(int data) throws IOException {
    this.bos.write(data);
  }
  
  //BufferedHttpResponseWrapper calls this method
  public void reset(){
    this.bos.reset();
  }
  
  //BufferedHttpResponseWrapper calls this method
  public void setBufferSize(int size){
    // no way to resize an existing ByteArrayOutputStream
    this.bos = new ByteArrayOutputStream(size);
  }

}
