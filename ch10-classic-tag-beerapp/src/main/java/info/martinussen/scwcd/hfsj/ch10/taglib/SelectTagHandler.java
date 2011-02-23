package info.martinussen.scwcd.hfsj.ch10.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * hfsj p 541
 * @author Henrik_2
 *
 */
public class SelectTagHandler extends SimpleTagSupport {
  private List optionsList;
  private String name;
  private String size;
  
  // store the ‘optionsList’ attribute
  public void setOptionsList(List optionsList) {
    this.optionsList = optionsList;
  }
  
  // store the ‘name’ attribute
  public void setName(String name) {
    this.name = name;
  }
  
  // store the ‘size’ attribute
  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public void doTag() throws JspException, IOException {
    // TODO Auto-generated method stub
    super.doTag();
  }
  
  

}
