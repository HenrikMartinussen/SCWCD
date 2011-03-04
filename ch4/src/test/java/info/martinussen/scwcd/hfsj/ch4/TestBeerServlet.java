package info.martinussen.scwcd.hfsj.ch4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.InOrder;

import static org.mockito.Mockito.*;

import info.martinussen.scwcd.hfsj.ch4.BeerServlet;
import junit.framework.TestCase;


public class TestBeerServlet extends TestCase {

  BeerServlet testBeerServlet = null;
  
  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    testBeerServlet = null;
    super.tearDown();
  }

  public void testBeerAppConstructor() {
    testBeerServlet = new BeerServlet();
    assertNotNull(testBeerServlet);
  }

  /**
   * Provides the BeerServlet with enough mocks to make it believe it is being run in a container.
   * Verifies that BeerServlet gets the color parameter and puts the styles attribute on the request.
   * Further verifies that BeerServlet obtains a RequestDispatcher from the mockRequest and subsequently 
   * forwards to "result.jsp"  
   * @throws ServletException, IOException
   */
  public void testBeerAppDoPost() throws ServletException, IOException {
    testBeerServlet = new BeerServlet();

    ServletConfig configMock = mock(ServletConfig.class);
    testBeerServlet.init(configMock);
    
    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    when(requestMock.getMethod()).thenReturn("POST"); //this forces the service method to delegate to doPost()
    when(requestMock.getParameter("color")).thenReturn("amber");
    
    
    RequestDispatcher reqDispatcherMock = mock(RequestDispatcher.class);
    when(requestMock.getRequestDispatcher("result.jsp")).thenReturn(reqDispatcherMock);
    
    HttpServletResponse responseMock = mock(HttpServletResponse.class);
    
    testBeerServlet.service(requestMock, responseMock );//delegates to doPost()
    
    testBeerServlet.destroy();
    
    InOrder inorder = inOrder(reqDispatcherMock, requestMock); //the order of the mocks is of no consequence
    inorder.verify(requestMock, times(1)).getMethod();
    inorder.verify(requestMock, times(1)).getParameter(eq("color"));
    inorder.verify(requestMock, times(1)).setAttribute(eq("styles"), anyListOf(String.class));
    inorder.verify(requestMock, times(1)).getRequestDispatcher(eq("result.jsp"));
    inorder.verify(reqDispatcherMock, times(1)).forward(eq(requestMock), eq(responseMock));
  }

}
