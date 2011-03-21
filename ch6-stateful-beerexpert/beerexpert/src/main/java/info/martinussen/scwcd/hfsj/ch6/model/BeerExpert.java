package info.martinussen.scwcd.hfsj.ch6.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;

/**
 * hfsj p 225
 * @author Henrik
 *
 */
public class BeerExpert implements HttpSessionBindingListener{

  private static Logger log = Logger.getLogger(BeerExpert.class);

  private State initialState;
  private State oneQestionAnsweredState;
  private State twoQuestionsAnsweredState;
  
  /*
   * The State implementations call setState on BeerExpert, thus setting 
   * one of its State instances as the current State. BeerExpert obviously 
   * doesn't handle its own state change - the State implementations does it
   * on behalf of BeerExpert. A drawback of this is that the State 
   * implementations are more tightly coupled.
   * Head First Design Patterns, p410 ff.
   */
  private State currentState;
  
  /** Holds the answer to the first question */
  private String answer1 = "";

  static {
    log.debug("BeerExpert is loaded");
  } 
  
  public BeerExpert() {
    log.debug("BeerExpert is being instantiated");
    initialState = new InitialState();
    oneQestionAnsweredState = new OneQuestionAnsweredState();
    twoQuestionsAnsweredState = new TwoQuestionsAnsweredState();
    currentState = initialState;
  }

  public NextResponse getAdvice(String answer) {
    return currentState.getAdvice(answer);
  }

  /**
   * state change implemented as State pattern (GoF) 
   */
  interface State {
    NextResponse getAdvice(String answer);
  }
  
  class InitialState implements State {
    public NextResponse getAdvice(String answer) {
      log.debug("Initial State.getAdvice() runs");
      if (!answer.equals("")){ 
        log.error("In initial State, BeerExpert only accepts an empty String as parameter");
        throw new IllegalArgumentException();
      }
      NextResponse response = new NextResponse(false, new String[] {"Dark", "Amber", "Pale"});
      log.debug("State is set to oneQuestionsAnsweredState");
      currentState = oneQestionAnsweredState; 
      return response;
    }
  }
  
  class OneQuestionAnsweredState implements State {
    public NextResponse getAdvice(String answer) {
      log.debug("OneQuestionAnswered State.getAdvice() runs");
      answer1 = answer;
      NextResponse response = new NextResponse(false, new String[] {"Cheap", "Regular", "Exclusive"});
      log.debug("State is set to twoQuestionsAnsweredState");
      currentState = twoQuestionsAnsweredState; 
      return response;
    }
  }

  class TwoQuestionsAnsweredState implements State {
    public NextResponse getAdvice(String answer2) {
      log.debug("TwoQuestionAnswered State.getAdvice() runs");
      String[] advice = {""};
      if (answer1.equals("Amber") && answer2.equals("Cheap")){
        advice[0] = "outsourced bitter ale";
      } else if (answer1.equals("Amber") && answer2.equals("Exclusive")){
        advice[0] = "leffe blonde";
      } else if (answer1.equals("Amber") && answer2.equals("Regular")){
        advice[0] = "tuborg classic";
      } else if (answer1.equals("Dark") && answer2.equals("Exclusive")){
        advice[0] = "carls dark abbey ale";
      } else {
        advice[0] = "gammel carlsberg porter";
      }
      log.debug("Advice " + advice[0] + " was returned");
      NextResponse response = new NextResponse(true, advice);
      log.debug("State is set back to InitialState");
      currentState = initialState;  
      return response;
    }
  }

  public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
    log.debug("BeerExpert was bound to session " + httpSessionBindingEvent.getSession().getId());
    
  }

  public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
    log.debug("BeerExpert was unBound from session " + httpSessionBindingEvent.getSession().getId());
  }
}

