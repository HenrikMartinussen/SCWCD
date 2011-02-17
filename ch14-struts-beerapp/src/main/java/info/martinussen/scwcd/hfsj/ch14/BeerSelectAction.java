package info.martinussen.scwcd.hfsj.ch14;

import java.util.List;

import info.martinussen.scwcd.hfsj.ch14.model.BeerExpert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BeerSelectAction extends Action {

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, 
                               HttpServletRequest request, HttpServletResponse response) throws Exception {
    // Cast the form to the application-specifc form
    BeerSelectForm myForm = (BeerSelectForm) form;
    
    // Process the business logic
    BeerExpert be = new BeerExpert();
    List result = be.getBrands(myForm.getColor());
    
    // Forward to the Results view
    // ( and store the data in the request-scope)
    request.setAttribute("styles", result);
    return mapping.findForward("show_results");
  }
  
  

}
