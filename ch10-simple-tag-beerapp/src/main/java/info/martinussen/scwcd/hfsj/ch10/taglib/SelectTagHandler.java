package info.martinussen.scwcd.hfsj.ch10.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * hfsj p 542, 558
 * @author Henrik
 *
 */
public class SelectTagHandler extends SimpleTagSupport implements DynamicAttributes {
  private static final String OPTION_START = "  <option value='";
  private static final String OPTION_END = " </option>";
  private List<String> optionsList;
  
  private String name;
  private Map<String, Object> tagAttrs = new HashMap<String, Object>();
  
  public void setOptionsList(List<String> optionsList) {
    this.optionsList = optionsList;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  // generate the <select> and <option> tags
  public void doTag() throws JspException, IOException {
       PageContext pageContext = (PageContext) getJspContext();
       JspWriter out = pageContext.getOut() ;
       String outString = "";

       // Start the HTML <select> tag with HTML-specific attributes
       outString = "<select name='" + this.name + "'";
       //add dynamic attributes
       for (String attrName : tagAttrs.keySet()){
         outString += " " + attrName + "='" + tagAttrs.get(attrName) + "'";
       }
       outString += ">";
       out.println(outString);

       // Generate the <option> tags from the optionsList
       for (String optionString : optionsList){
         outString = OPTION_START + optionString + "'> " + optionString + OPTION_END;
         out.println(outString);
       }
       
       // End the HTML </select> tag
       outString = "</select>";
       out.println(outString);
  }

  public void setDynamicAttribute(String uri, String name, Object value)
      throws JspException {
    tagAttrs.put(name, value);
  }
}
