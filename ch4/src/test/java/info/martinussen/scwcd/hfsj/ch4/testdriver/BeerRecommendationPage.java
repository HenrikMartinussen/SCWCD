package info.martinussen.scwcd.hfsj.ch4.testdriver;

import java.util.List;

public class BeerRecommendationPage extends Page {
    private String header;
    private List<String> recommendations;

    public boolean headerContainsIgnoreCase(String fragment){
        final boolean returnValue;
        if (header.toLowerCase().contains(fragment.toLowerCase())){
            returnValue = true;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    public boolean recommendationsContainsIgnoreCase(){
        return false;
    }


}
