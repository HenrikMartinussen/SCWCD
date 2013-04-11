package info.martinussen.scwcd.hfsj.ch13;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/** 
 * A response wrapper that takes everything the client
 * would normally output and saves it in one large string.
 * CSJP p. 235-236
 */
public class StringWrapper extends HttpServletResponseWrapper {

  private StringWriter stringWriter;

  /** Initializes wrapper.
   * <P>
   * First, this constructor calls the parent
   * constructor. That call is crucial so that the response
   * is stored and thus setHeader, setStatus, addCookie,
   * and so forth work normally.
   * <P>
   * Second, this constructor creates a StringWriter
   * that will be used to accumulate the response.
   */
  public StringWrapper(HttpServletResponse response) {
    super(response);
    stringWriter = new StringWriter();
  }

  @Override
  public PrintWriter getWriter() throws IOException {
    return new PrintWriter(stringWriter);
  }

  @Override
  public ServletOutputStream getOutputStream() throws IOException {
    return new StringOutputStream(stringWriter);
  }

  /** Get a String representation of the entire buffer.
  * <P>
  * Be sure <I>not</I> to call this method multiple times
  * on the same wrapper. The API for StringWriter
  * does not guarantee that it "remembers" the previous
  * value, so the call is likely to make a new String
  * every time.
  */
  public String toString() {
    return(stringWriter.toString());
  }

  /** Get the underlying StringBuffer. */
  public StringBuffer getBuffer() {
    return(stringWriter.getBuffer());
  }

  
}
