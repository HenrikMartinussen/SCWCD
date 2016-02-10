package info.martinussen.scwcd.hfsj.ch4.testdriver;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ColorSelectionPage extends Page{
    public static final String COLOR_LIGHT = "light";
    public static final String COLOR_AMBER = "amber";
    public static final String COLOR_BROWN = "brown";
    public static final String COLOR_DARK  = "dark";

    private String color = "";

    private WebClient webClient;
    private HtmlPage startForm;


    public ColorSelectionPage(String url) {
        webClient = new WebClient();
        try {
            startForm = (HtmlPage) webClient.getPage(url);
            this.setTitle(startForm.getTitleText());
        } catch (IOException e) {
            throw new RuntimeException(e); //Rethrow as RTE
        }
    }

    public void selectColor(String color){
        if (!(color.equals(COLOR_LIGHT) || color.equals(COLOR_AMBER) || color.equals(COLOR_BROWN) || color.equals(COLOR_DARK))){
            throw new IllegalArgumentException("Use one of this class' constants as color");
        }
        this.color = color;
        HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
        HtmlOption option = select.getOptionByValue(this.color);
        select.setSelectedAttribute(option, true);
    }

    public BeerRecommendationPage clickSubmit() {
        if (!(color.equals(COLOR_LIGHT) || color.equals(COLOR_AMBER) || color.equals(COLOR_BROWN) || color.equals(COLOR_DARK))){
            throw new IllegalStateException("Select color before clicking submit");
        }
        HtmlSubmitInput submit =  (HtmlSubmitInput) startForm.getElementsByTagName("input").item(0);

        HtmlPage resultPage = null;
        try {
            resultPage = submit.click();
        } catch (IOException e) {
            throw new RuntimeException(e); // Rethrow as RTE
        }
        HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
        HtmlHeading1 heading = (HtmlHeading1) resultPage.getElementsByTagName("h1").item(0);
        //Build page
        BeerRecommendationPage beerRecommendationPage = new BeerRecommendationPage(heading.asText(), p.asText());
        beerRecommendationPage.setTitle(resultPage.getTitleText());

        return beerRecommendationPage;
    }




}
