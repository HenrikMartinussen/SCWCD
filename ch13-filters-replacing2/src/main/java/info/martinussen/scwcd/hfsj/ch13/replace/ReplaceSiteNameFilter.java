package info.martinussen.scwcd.hfsj.ch13.replace;

public class ReplaceSiteNameFilter extends ModificationFilter {

  private boolean isCaseInsensitive = false;

  @Override
  public String doModification(String orig) {
    if ((getTarget() == null) || (getReplacement() == null)) {
      return orig;
    } else {
      String target = getTarget();
      if (isCaseInsensitive()) {
        target = "(?i)" + target;
      }
      String replacement = getReplacement();
      return orig.replaceAll(target, replacement);
    }
  }

  private boolean isCaseInsensitive() {
    return isCaseInsensitive;
  }

  /** 
   * The string that needs replacement.
   */
  public String getTarget() {
    return getInitParameter("target");
  }

  /** 
   * The string that replaces the target.
   */
  public String getReplacement() {
    return getInitParameter("replacement");
  }

  /** 
   * Returns the init parameter value specified by 'param' or
   * null if it is not present or an empty string
   */
  private String getInitParameter(String param) {
    String value = config.getInitParameter(param);
    if ((value == null) || (value.trim().equals(""))) {
      value = null;
    }
    return value;
  }

}
