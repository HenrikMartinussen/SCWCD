package info.martinussen.scwcd.hfsj.ch13;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletOutputStream;

/** 
 * StringOutputStream is a stub for ServletOutputStream which
 * buffers up the output in a string buffer instead of sending it
 * straight to the client.
 * CSJP p. 237
 */
public class StringOutputStream extends ServletOutputStream {
  
  private StringWriter stringWriter;

  public StringOutputStream(StringWriter stringWriter) {
    this.stringWriter = stringWriter;
  }

  @Override
  public void write(int c) throws IOException {
    stringWriter.write(c);
  }

}
