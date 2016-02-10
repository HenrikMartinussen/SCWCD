package info.martinussen.scwcd.hfsj.ch4.testdriver;


public class BeerRecommendationPage extends Page {
    private String header;
    private String recommendation;

    public BeerRecommendationPage(String header, String recommendation){
        if (header != null && recommendation != null){
            this.header = header;
            this.recommendation = recommendation;
        }
    }

    public boolean headerContainsIgnoreCase(String fragment){
        final boolean returnValue;
        if (header.toLowerCase().contains(fragment.toLowerCase())){
            returnValue = true;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    public boolean recommendationsContainsIgnoreCase(String fragment){
        boolean returnValue = false;
        if (recommendation.toLowerCase().contains(fragment.toLowerCase())){
            returnValue = true;
        }
        return returnValue;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
