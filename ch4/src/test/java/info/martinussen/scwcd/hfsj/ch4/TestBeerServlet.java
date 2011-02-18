package info.martinussen.scwcd.hfsj.ch4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

  public void testBeerAppDoPost()throws ServletException, IOException {
    testBeerServlet = new BeerServlet();

    ServletConfig configMock = mock(ServletConfig.class);
    testBeerServlet.init(configMock);
    
    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    when(requestMock.getParameter("color")).thenReturn("amber");
    
    RequestDispatcher reqDispatcherMock = mock(RequestDispatcher.class);
    when(requestMock.getRequestDispatcher("result.jsp")).thenReturn(reqDispatcherMock);
    
    HttpServletResponse responseMock = mock(HttpServletResponse.class);
    testBeerServlet.doPost(requestMock, responseMock );
    
    verify(requestMock, times(1)).getParameter(eq("color"));
    verify(requestMock, times(1)).setAttribute(eq("styles"), anyObject());
    verify(requestMock, times(1)).getRequestDispatcher(eq("result.jsp"));
    verify(reqDispatcherMock, times(1)).forward(eq(requestMock), eq(responseMock));
  }

}
