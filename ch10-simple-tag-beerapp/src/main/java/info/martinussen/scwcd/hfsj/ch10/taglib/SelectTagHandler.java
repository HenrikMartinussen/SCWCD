package info.martinussen.scwcd.hfsj.ch10.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * hfsj p 542
 * @author Henrik
 *
 */
public class SelectTagHandler extends SimpleTagSupport {
  private static final String OPTION_START = "  <option value='";
  private static final String OPTION_END = " </option>";
  private List optionsList;
  private String name;
  private String size;
  
  // store the 'optionsList' attribute
  public void setOptionsList(List optionsList) {
    this.optionsList = optionsList;
  }
  
  // store the 'name' attribute
  public void setName(String name) {
    this.name = name;
  }
  
  // store the 'size' attribute
  public void setSize(String size) {
    this.size = size;
  }

  @Override
  // generate the <select> and <option> tags
  public void doTag() throws JspException, IOException {
       PageContext pageContext = (PageContext) getJspContext();
       JspWriter out = pageContext.getOut() ;
       String outString = "";

       // Start the HTML <select> tag with HTML-specifc attributes
       outString = "<select name='" + this.name + "' size='" + this.size + "'>";
       out.println(outString);

       // Generate the <option> tags from the optionsList
       for (int i = 0; i < optionsList.size(); i++){
         outString = OPTION_START + optionsList.get(i) + "'> " + optionsList.get(i) + OPTION_END;
         out.println(outString);
       }
       
       // End the HTML </select> tag
       outString = "</select>";
       out.println(outString);
  }
}
