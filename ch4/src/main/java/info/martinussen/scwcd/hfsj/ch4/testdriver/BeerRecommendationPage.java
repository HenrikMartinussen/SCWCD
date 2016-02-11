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

    public String getHeader(){
        return header;
    }

    public String getRecommendation(){
        return recommendation;
    }
}
