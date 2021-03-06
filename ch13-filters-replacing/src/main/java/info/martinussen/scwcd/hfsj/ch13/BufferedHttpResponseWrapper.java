package info.martinussen.scwcd.hfsj.ch13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

//Java and xslt p.317


/**
 * A custom response wrapper that captures all output in a buffer.
 * @author Eric M. Burke
 */
public class BufferedHttpResponseWrapper extends HttpServletResponseWrapper{

  private BufferedServletOutputStream bufferedServletOut = new BufferedServletOutputStream();
  private PrintWriter printWriter = null;
  private ServletOutputStream outputStream = null;

  public BufferedHttpResponseWrapper(HttpServletResponse origResponse) {
    super(origResponse);
  }

  public byte[] getBuffer(){
    return this.bufferedServletOut.getBuffer();
  }

  public PrintWriter getWriter(){
    if (this.outputStream != null){
      throw new IllegalStateException("The Servlet API forbids calling getWriter() after "
                                    + "getOutputStream() has been called");
    } 
    
    if (this.printWriter == null){
      this.printWriter = new PrintWriter(this.bufferedServletOut);
    }
    
    return this.printWriter;
  }

  public ServletOutputStream getOutputStream(){
    if (this.printWriter != null){
      throw new IllegalStateException("The Servlet API forbids calling getOutputStream() after "
                                    + "getWriter() has been called");
    }
    
    if (this.outputStream == null){
      this.outputStream = this.bufferedServletOut;
    }
    
    return this.outputStream;
  }

  //override methods that deal with the response buffer

  public void flushBuffer() throws IOException {
    if (this.outputStream != null) {
      this.outputStream.flush();
    } else {
      if (this.printWriter != null) {
        this.printWriter.flush();
      } 
    }
  }

  public int getBufferSize(  ) {
    return this.bufferedServletOut.getBuffer(  ).length;
  }

  public void reset(  ) {
    this.bufferedServletOut.reset(  );
  }

  public void resetBuffer(  ) {
    this.bufferedServletOut.reset(  );
  }

  public void setBufferSize(int size) {
    this.bufferedServletOut.setBufferSize(size);
  }

}
