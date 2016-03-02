package info.martinussen.scwcd.hfsj.ch4.testdriver;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

/**
 * Abstraction over the entry page of the Beer Selector application
 * This class can be used to perform integration/system tests, while encapsulating the browser driving.
 */
public class BeerSelectionPage extends Page{
    public static final String COLOR_LIGHT = "light";
    public static final String COLOR_AMBER = "amber";
    public static final String COLOR_BROWN = "brown";
    public static final String COLOR_DARK  = "dark";

    private String    color = "";

    private WebClient webClient;
    private HtmlPage  startForm;


    private BeerSelectionPage(String url) {
        webClient = new WebClient();
        try {
            startForm = webClient.getPage(url);
        } catch (IOException e) {
            throw new RuntimeException(e); //Rethrow as RTE
        }
        this.setTitle(startForm.getTitleText());
    }

    public static BeerSelectionPage showPage(String url){

        BeerSelectionPage page = new BeerSelectionPage(url);
        return page;
    }

    /**
     * This method lets client interact with the color drop-down
     * @param color
     */
    public void selectColor(String color){
        if (!(color.equals(COLOR_LIGHT) || color.equals(COLOR_AMBER) || color.equals(COLOR_BROWN) || color.equals(COLOR_DARK))){
            throw new IllegalArgumentException("Use one of this class' constants as color");
        }
        this.color = color;
        HtmlSelect select = (HtmlSelect) startForm.getElementsByTagName("select").item(0);
        HtmlOption option = select.getOptionByValue(this.color);
        select.setSelectedAttribute(option, true);
    }

    /**
     * This method lets the client click the Submit button, resulting in a new page (abstraction) being returned; the BeerRecommendation page.
     * A color must be selected before clicking the submit button.
     *
     * @return the BeerRecommendationPage object resulting from clicking the submit button
     */
    public BeerRecommendationPage clickSubmit() {
        if (!(color.equals(COLOR_LIGHT) || color.equals(COLOR_AMBER) || color.equals(COLOR_BROWN) || color.equals(COLOR_DARK))){
            throw new IllegalStateException("Select color before clicking submit"); //TODO actually the dropdown has a default value, alas the abstraction differs from the reality...
        }
        //find the submit button on the page
        HtmlSubmitInput submit = (HtmlSubmitInput) startForm.getElementsByTagName("input").item(0);

        HtmlPage resultPage;
        try {
            resultPage = submit.click();
        } catch (IOException e) {
            throw new RuntimeException(e); // Rethrow as RTE
        }
        //find the heading and the advice paragraph on the return HtmlPage
        HtmlHeading1 heading = (HtmlHeading1) resultPage.getElementsByTagName("h1").item(0);
        HtmlParagraph p = (HtmlParagraph) resultPage.getElementsByTagName("p").item(0);
        //Build page abstraction object
        BeerRecommendationPage beerRecommendationPage = new BeerRecommendationPage(heading.asText(), p.asText());
        beerRecommendationPage.setTitle(resultPage.getTitleText());

        return beerRecommendationPage;
    }




}
