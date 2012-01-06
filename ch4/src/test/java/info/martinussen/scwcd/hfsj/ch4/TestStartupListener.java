package info.martinussen.scwcd.hfsj.ch4;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Test;
import org.mockito.InOrder;


public class TestStartupListener {

	ServletContextListener startupListener = null;
  
  @After
  public void tearDown() throws Exception {
    startupListener = null;
  }

  @Test
  public void testStartupListenerConstructor() {
    startupListener = new StartupListener();
    assertNotNull(startupListener);
  }

  /**
   * Provides the StartupListener with enough mocks to make it believe it is being run in a container.
   * Verifies that StartupListener, when its contextInitialized method is called, gets a ServletContext(Mock) from the
   * ServletContextEvent(Mock) and places an object on the ServletContext(Mock) as an attribute with the key "beerExpert".
   * Further verifies that StartupListener doesn't exhibit further interactions.
   * @throws ServletException, IOException
   */
  @Test
  public void testStartupListenerContextInitialized() throws ServletException, IOException {
    startupListener = new StartupListener();
    
    ServletContext servletContextMock = mock(ServletContext.class);

    ServletContextEvent servletContextEventMock = mock(ServletContextEvent.class);
    when(servletContextEventMock.getServletContext()).thenReturn(servletContextMock);
    
    startupListener.contextInitialized(servletContextEventMock);

    InOrder inorder = inOrder(servletContextMock, servletContextEventMock); //the order of the mocks is of no consequence
    inorder.verify(servletContextEventMock, times(1)).getServletContext();
    inorder.verify(servletContextMock, times(1)).setAttribute(eq("beerExpert"), anyObject());
    inorder.verifyNoMoreInteractions();
  }
}
