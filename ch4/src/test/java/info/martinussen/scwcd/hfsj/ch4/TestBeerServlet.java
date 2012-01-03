package info.martinussen.scwcd.hfsj.ch4;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Test;
import org.mockito.InOrder;


public class TestBeerServlet {

  BeerServlet testBeerServlet = null;
  
  @After
  public void tearDown() throws Exception {
    testBeerServlet = null;
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
  @Test
  public void testBeerAppDoPost() throws ServletException, IOException {
    testBeerServlet = new BeerServlet();

    ServletContext servletContextMock = mock(ServletContext.class);
    when(servletContextMock.getAttribute("beerExpert")).thenReturn(new BeerExpert()); //TODO return a mock instead
    
    ServletConfig configMock = mock(ServletConfig.class);
	when(configMock.getServletContext()).thenReturn(servletContextMock);
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
