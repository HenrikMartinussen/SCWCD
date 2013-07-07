package info.martinussen.keyfile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.anyString;
import static org.mockito.Matchers.eq;

import java.io.IOException;
import java.io.InputStream;

import info.martinussen.keyfile.model.ProductKey;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class TestProductKeyBuilder {

  ProductKeyBuilder testBuilder  = null;
  
  @Before
  public void setUp() throws Exception {
    testBuilder = new ProductKeyBuilder();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test1() throws IOException {
    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    when(requestMock.getParameter("version")).thenReturn("Light");
    when(requestMock.getParameter("customerName")).thenReturn("Carlsberg A/S");
    when(requestMock.getParameter("orderNumber")).thenReturn("00001");
    when(requestMock.getParameter("clientCount")).thenReturn("1");
    when(requestMock.getParameter("automatCount")).thenReturn("1");
    when(requestMock.getParameter("liftEnabled")).thenReturn(null);
    when(requestMock.getParameter("trayAccessControlEnabled")).thenReturn("on");
    when(requestMock.getParameter("lotSerialEnabled")).thenReturn("on");
    when(requestMock.getParameter("webStatusPageEnabled")).thenReturn("on");
    when(requestMock.getParameter("tiltEnabled")).thenReturn(null);
    ProductKey testKey = testBuilder.buildProductKey(requestMock);
    String key = testKey.getKeyAsXmlString();
    InOrder inOrder = inOrder(requestMock);
    inOrder.verify(requestMock).getParameter("version");
    inOrder.verify(requestMock).getParameter("customerName");
    inOrder.verify(requestMock).setAttribute(eq("customerNameRaw"), anyString());
    inOrder.verify(requestMock).getParameter("orderNumber");
    inOrder.verify(requestMock).setAttribute(eq("formattedOrderNumber"), anyString());
    inOrder.verify(requestMock).getParameter("clientCount");
    inOrder.verify(requestMock).getParameter("automatCount");
    inOrder.verify(requestMock).getParameter("liftEnabled");
    inOrder.verify(requestMock).getParameter("trayAccessControlEnabled");
    inOrder.verify(requestMock).getParameter("lotSerialEnabled");
    inOrder.verify(requestMock).getParameter("webStatusPageEnabled");
    inOrder.verify(requestMock).getParameter("tiltEnabled");
    
    InputStream expected = getClass().getClassLoader().getResourceAsStream("expected1.xml");
    assertEquals( IOUtils.toString( expected ), key);
    
  }

  @Test
  public void test5() throws IOException {
    HttpServletRequest requestMock = mock(HttpServletRequest.class);
    when(requestMock.getParameter("version")).thenReturn("Standard");
    when(requestMock.getParameter("customerName")).thenReturn("Faxe");
    when(requestMock.getParameter("orderNumber")).thenReturn("00005");
    when(requestMock.getParameter("clientCount")).thenReturn("1");
    when(requestMock.getParameter("automatCount")).thenReturn("1");
    when(requestMock.getParameter("liftEnabled")).thenReturn(null);
    when(requestMock.getParameter("trayAccessControlEnabled")).thenReturn(null);
    when(requestMock.getParameter("lotSerialEnabled")).thenReturn(null);
    when(requestMock.getParameter("webStatusPageEnabled")).thenReturn(null);
    when(requestMock.getParameter("tiltEnabled")).thenReturn("on");
    ProductKey testKey = testBuilder.buildProductKey(requestMock);
    String key = testKey.getKeyAsXmlString();
    InOrder inOrder = inOrder(requestMock);
    inOrder.verify(requestMock).getParameter("version");
    inOrder.verify(requestMock).getParameter("customerName");
    inOrder.verify(requestMock).setAttribute(eq("customerNameRaw"), anyString());
    inOrder.verify(requestMock).getParameter("orderNumber");
    inOrder.verify(requestMock).setAttribute(eq("formattedOrderNumber"), anyString());
    inOrder.verify(requestMock).getParameter("clientCount");
    inOrder.verify(requestMock).getParameter("automatCount");
    inOrder.verify(requestMock).getParameter("liftEnabled");
    inOrder.verify(requestMock).getParameter("trayAccessControlEnabled");
    inOrder.verify(requestMock).getParameter("lotSerialEnabled");
    inOrder.verify(requestMock).getParameter("webStatusPageEnabled");
    inOrder.verify(requestMock).getParameter("tiltEnabled");
    
    InputStream expected = getClass().getClassLoader().getResourceAsStream("expected5.xml");
    assertEquals( IOUtils.toString( expected ), key);
    
  }

}
