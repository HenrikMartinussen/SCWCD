package info.martinussen.scwcd.hfsj.ch13.replace;

import org.apache.log4j.Logger;

public class Rule {
  private Logger log = Logger.getLogger(Rule.class);
  private String toBeReplaced;
  private String replaceWith;
  
  public Rule(String tbr, String rw){
    this.toBeReplaced = tbr;
    this.replaceWith = rw;
    log.debug("Rule constructed - tbr: " + tbr + " rw: " + rw);
  }

  public String getToBeReplaced() {
    return toBeReplaced;
  }

  public String getReplaceWith() {
    return replaceWith;
  }
}
  
  