package info.martinussen.scwcd.hfsj.ch4.testdriver;

public class BeerRecommendationTestFixture {
  private String color;
  private BeerRecommendationPage beerRecommendationPage;

  public void setColor(String color){
    this.color = color;
  }

  public boolean fetchAdvice(){
    BeerSelectionPage beerSelectionPage = BeerSelectionPage.showPage("http://localhost:8081/ch4");
    beerSelectionPage.selectColor(color);
    beerRecommendationPage = beerSelectionPage.clickSubmit();
    if (beerRecommendationPage == null){
      throw new NullPointerException("beerRecommendationPage was unexpectedly null");
    }
    return (pageTitleContains("Beer recommendations") && pageHeaderContains("Beer recommendations JSP"));
  }

  public boolean adviceContainsJailPaleAle(){
    return adviceContains("Jail Pale Ale");
  }

  public boolean adviceContainsGoutStout(){
    return adviceContains("Gout Stout");
  }

  public boolean adviceContainsJackAmber(){
    return adviceContains("Jack Amber");
  }

  public boolean adviceContainsRedMoose(){
    return adviceContains("Red Moose");
  }

  private boolean pageTitleContains(String expectedTitleFragment){
    boolean returnValue = false;
    if (beerRecommendationPage.getTitle().toUpperCase().contains(expectedTitleFragment.toUpperCase())){
      returnValue = true;
    }
    return returnValue;
  }

  private boolean pageHeaderContains(String expectedHeaderFragment){
    boolean returnValue = false;
    if (beerRecommendationPage.getHeader().toUpperCase().contains(expectedHeaderFragment.toUpperCase())){
      returnValue = true;
    }
    return returnValue;
  }

  private boolean adviceContains(String advice){
    boolean returnValue = false;
    if (beerRecommendationPage != null && advice != null && beerRecommendationPage.getRecommendation().toUpperCase().contains(advice.toUpperCase())){
      returnValue = true;
    }
    return returnValue;
  }
}
