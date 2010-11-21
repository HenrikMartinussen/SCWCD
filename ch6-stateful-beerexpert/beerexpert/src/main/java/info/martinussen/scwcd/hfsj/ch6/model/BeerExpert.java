package info.martinussen.scwcd.hfsj.ch6.model;

public class BeerExpert {
  

  State initialState;
  State oneQestionAnsweredState;
  State twoQuestionsAnsweredState;

  State state;
  
  String answer1 = "";

  public BeerExpert() {
    initialState = new InitialState(this);
    oneQestionAnsweredState = new OneQuestionAnsweredState(this);
    twoQuestionsAnsweredState = new TwoQuestionsAnsweredState(this);
    state = initialState;
  }

  public NextResponse getAdvice(String answer) {
    return state.getAdvice(answer);
  }

  public State getInitialState() {
    return initialState;
  }

  public State getOneQuestionAnsweredState() {
    return oneQestionAnsweredState;
  }
  
  public State getTwoQuestionsAnsweredState() {
    return twoQuestionsAnsweredState;
  }

  public void setState(State state) {
    this.state = state;
  }
  
  public void setAnswer1(String answer1){
    this.answer1 = answer1;
  }

  public String getAnswer1(){
    return answer1;
  }

  interface State {
    NextResponse getAdvice(String answer);
    
  }
  
  class InitialState implements State {
    BeerExpert beerExpert;

    public InitialState(BeerExpert beerExpert) {
      this.beerExpert = beerExpert; 
    }

    public NextResponse getAdvice(String answer) {
      if (!answer.equals("")){ 
        throw new IllegalArgumentException();
      }
      NextResponse response = new NextResponse(false, new String[] {"Dark", "Amber", "Pale"});
      beerExpert.setState(beerExpert.getOneQuestionAnsweredState());
      return response;
    }
    
  }
  
  class OneQuestionAnsweredState implements State {
    BeerExpert beerExpert;

    public OneQuestionAnsweredState(BeerExpert beerExpert) {
      this.beerExpert = beerExpert; 
    }

    public NextResponse getAdvice(String answer) {
      beerExpert.setAnswer1(answer);
      NextResponse response = new NextResponse(false, new String[] {"Cheap", "Regular", "Exclusive"});
      beerExpert.setState(beerExpert.getTwoQuestionsAnsweredState());
      return response;
    }
  }

  class TwoQuestionsAnsweredState implements State {
    BeerExpert beerExpert;
    
    public TwoQuestionsAnsweredState(BeerExpert beerExpert) {
      this.beerExpert = beerExpert; 
    }

    public NextResponse getAdvice(String answer2) {
      String[] advice = {""};
      if (beerExpert.getAnswer1().equals("Amber") && answer2.equals("Cheap")){
        advice[0] = "outsourced bitter ale";
      } else if (beerExpert.getAnswer1().equals("Amber") && answer2.equals("Exclusive")){
        advice[0] = "leffe blonde";
      } else if (beerExpert.getAnswer1().equals("Amber") && answer2.equals("Regular")){
        advice[0] = "tuborg classic";
      } else {
        advice[0] = "gammel carlsber porter";
      }
      NextResponse response = new NextResponse(true, advice);
      beerExpert.setState(beerExpert.getInitialState());
      return response;
    }
    
  }

}

