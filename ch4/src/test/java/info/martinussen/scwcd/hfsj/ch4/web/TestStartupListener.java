package info.martinussen.scwcd.hfsj.ch4.web;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import info.martinussen.scwcd.hfsj.ch4.StartupListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;


public class TestStartupListener {

  ServletContextListener startupListener = null;

  @Before
  public void setUp(){
    startupListener = new StartupListener();
  }

  @After
  public void tearDown() throws Exception {
    startupListener = null;
  }

  @Test
  public void testStartupListenerConstructor() {
    assertNotNull(startupListener);
  }

  /**
   * Provides the StartupListener with enough mocks to make it believe it is being run in a container.
   * Verifies that StartupListener, when its contextInitialized method is called, gets a ServletContext(Mock) from the
   * ServletContextEvent(Mock) and places an object on the ServletContext(Mock) as an attribute with the key "beerExpert".
   * Further verifies that StartupListener doesn't exhibit further interactions.
   */
  @Test
  public void testStartupListenerContextInitialized()  {
    ServletContext servletContextMock = mock(ServletContext.class);

    ServletContextEvent servletContextEventMock = mock(ServletContextEvent.class);
    when(servletContextEventMock.getServletContext()).thenReturn(servletContextMock);

    startupListener.contextInitialized(servletContextEventMock);

    InOrder inorder = inOrder(servletContextMock, servletContextEventMock); //the order of the mocks is of no consequence
    inorder.verify(servletContextEventMock, times(1)).getServletContext();
    inorder.verify(servletContextMock, times(1)).setAttribute(eq("beerExpert"), anyObject());
    inorder.verifyNoMoreInteractions();
  }

  /**
   * Provides the StartupListener with enough mocks to make it believe it is being run in a container.
   * Verifies that StartupListener, when its contextDestroyed method is called, gets a ServletContext(Mock) from the
   * ServletContextEvent(Mock) and removes an attribute from the ServletContext(Mock) with the key "beerExpert".
   * Further verifies that StartupListener doesn't exhibit further interactions.
   */
  @Test
  public void testStartupListenerContextDestroyedPiphans(){
    ServletContext servletContextMock = mock(ServletContext.class);

    ServletContextEvent servletContextEventMock = mock(ServletContextEvent.class);
    when(servletContextEventMock.getServletContext()).thenReturn(servletContextMock);

    startupListener.contextDestroyed(servletContextEventMock);

    InOrder inorder = inOrder(servletContextMock, servletContextEventMock);
    inorder.verify(servletContextEventMock, times(1)).getServletContext();
    inorder.verify(servletContextMock, times(1)).removeAttribute(eq("beerExpert"));
    inorder.verifyNoMoreInteractions();
  }

}
