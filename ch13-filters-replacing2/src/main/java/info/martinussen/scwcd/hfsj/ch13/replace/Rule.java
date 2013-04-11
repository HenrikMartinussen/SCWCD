package info.martinussen.scwcd.hfsj.ch13.replace;

//import org.apache.log4j.Logger;

public class Rule {
  //private Logger log = Logger.getLogger(Rule.class);
  private String toBeReplaced;
  private String replaceWith;
  
  public Rule(String tbr, String rw){
    this.toBeReplaced = tbr;
    this.replaceWith = rw;
  }

  public String getToBeReplaced() {
    return toBeReplaced;
  }

  public String getReplaceWith() {
    return replaceWith;
  }
  
  public String toString(){
    return "Rule[Replace " + toBeReplaced  + " with " + replaceWith + "]";
  }
  
  //Maybe rules could be chained, passing the String to be changed along the chain
  //Thus delegating the responsibility to do the change to the rule object - According to 
  //the oop principle "Don't ask an object for data so you can do the work, ask the object to do the work"
}
  
  