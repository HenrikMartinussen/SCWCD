package info.martinussen.scwcd.hfsj.ch6.model;

public class NextResponse {
  
  private boolean finalAdvice = false;
  private String[] messages = null;
  
  private NextResponse(){
    
  }
  
  public NextResponse(boolean finalAdvice, String[] messages){
    this();
    this.finalAdvice = finalAdvice;
    this.messages = messages;
  }
  
  public boolean isFinalAdvice(){
    return finalAdvice;
  }
  
  public String[] getMessages(){
    return messages;
  }

}
