package info.martinussen.scwcd.hfsj.ch10.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import org.mockito.InOrder;

import info.martinussen.scwcd.hfsj.ch10.taglib.SelectTagHandler;
import junit.framework.TestCase;

public class TestSelectTagHandler extends TestCase {
  
  String CRLF = System.getProperty("line.separator");
  SelectTagHandler testSelect = null;

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }
  
  public void testSelectTagHandlerDoTag() throws IOException, JspException{
    List testOptions = new ArrayList();
    testOptions.add("light");
    testOptions.add("amber");
    testOptions.add("brown");
    testOptions.add("dark");
    
    testSelect = new SelectTagHandler();

    JspContext mockJspContext = mock(PageContext.class);//PageContext is-a JspContext
    JspWriter mockJspWriter = mock(JspWriter.class);
    when(mockJspContext.getOut()).thenReturn(mockJspWriter );
    
    testSelect.setJspContext(mockJspContext);
    testSelect.setName("color");
    testSelect.setSize("1");
    testSelect.setOptionsList(testOptions);
    
    testSelect.doTag();
    
    InOrder inorder = inOrder(mockJspContext, mockJspWriter);
    inorder.verify(mockJspContext, times(1)).getOut();
    inorder.verify(mockJspWriter, times(1)).println(eq("<select name='color' size='1'>"));
    inorder.verify(mockJspWriter, times(1)).println(eq("  <option value='light'> light </option>"));
    inorder.verify(mockJspWriter, times(1)).println(eq("  <option value='amber'> amber </option>"));
    inorder.verify(mockJspWriter, times(1)).println(eq("  <option value='brown'> brown </option>"));
    inorder.verify(mockJspWriter, times(1)).println(eq("  <option value='dark'> dark </option>"));
    inorder.verify(mockJspWriter, times(1)).println(eq("</select>"));
  }

}
