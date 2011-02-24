package info.martinussen.scwcd.hfsj.ch7;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.InOrder;

import static org.mockito.Mockito.*;

import junit.framework.TestCase;

/**
 * hfsj p 300
 * @author Henrik
 */
public class TestHobbiesServlet extends TestCase {

  HobbiesServlet testHobbiesServlet = null;
  
  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    testHobbiesServlet = null;
    super.tearDown();
  }

  /**
   * Provides the HobbiesServlet with enough mocks to make it believe it is 
   * being run in a container.
   * Verifies that HobbiesServlet gets the hobby parameter and puts the friend 
   * attribute on the request.
   * Further verifies that HobbiesServlet obtains a RequestDispatcher from the 
   * mockRequest and subsequently forwards to "result.jsp"  
   * @throws ServletException, IOException
   */
  public void testHobbiesServletDoPost() throws ServletException, IOException {
    testHobbiesServlet = new HobbiesServlet();

    ServletConfig configMock = mock(ServletConfig.class);
    testHobbiesServlet.init(configMock);
    
    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    when(requestMock.getMethod()).thenReturn("POST"); //this forces the service method to delegate to doPost()
    when(requestMock.getParameter("hobby")).thenReturn("extreme knitting");
    
    
    RequestDispatcher reqDispatcherMock = mock(RequestDispatcher.class);
    when(requestMock.getRequestDispatcher("result.jsp")).thenReturn(reqDispatcherMock);
    
    HttpServletResponse responseMock = mock(HttpServletResponse.class);
    
    testHobbiesServlet.service(requestMock, responseMock );//delegates to doPost()
    
    InOrder inorder = inOrder(reqDispatcherMock, requestMock); //the order of the mocks is of no consequence
    inorder.verify(requestMock, times(1)).getMethod();
    inorder.verify(requestMock, times(1)).getParameter(eq("hobby"));
    inorder.verify(requestMock, times(1)).setAttribute(eq("names"), anyListOf(String.class));
    inorder.verify(requestMock, times(1)).getRequestDispatcher(eq("result.jsp"));
    inorder.verify(reqDispatcherMock, times(1)).forward(eq(requestMock), eq(responseMock));
  }
}
