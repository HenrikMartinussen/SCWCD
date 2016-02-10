package info.martinussen.scwcd.hfsj.ch4.integration;

import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerRecommendationPage;
import info.martinussen.scwcd.hfsj.ch4.testdriver.ColorSelectionPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class Ch4ITCase {

    private String testColor;
    private String expected1;
    private String expected2;

    ColorSelectionPage colorSelectionPage;

    @Parameterized.Parameters
    public static Collection<String[]> getTestParameters(){
        return Arrays.asList(new String[][]{
                {ColorSelectionPage.COLOR_AMBER, "Jack Amber",    "Red Moose"}, // value, expected1, expected2
                {ColorSelectionPage.COLOR_LIGHT, "Jail Pale Ale", "Gout Stout"},
                {ColorSelectionPage.COLOR_BROWN, "Jail Pale Ale", "Gout Stout"},
                {ColorSelectionPage.COLOR_DARK,  "Jail Pale Ale", "Gout Stout"}
        });
    }

    public Ch4ITCase(String testColor, String expected1, String expected2){
        this.testColor = testColor;
        this.expected1 = expected1;
        this.expected2 = expected2;
    }

    @Before
    public void setUp(){
        colorSelectionPage = new ColorSelectionPage("http://localhost:8081/ch4");
        assertTrue(colorSelectionPage.titleContainsIgnoreCase("Beer Selection Page"));
    }

    @Test
    public void testCh4(){
        colorSelectionPage.selectColor(testColor);
        BeerRecommendationPage beerRecommendationPage = colorSelectionPage.clickSubmit();
        assertTrue(beerRecommendationPage.titleContainsIgnoreCase("Beer recommendations"));
        assertTrue(beerRecommendationPage.headerContainsIgnoreCase("Beer Recommendations JSP"));
        assertTrue(beerRecommendationPage.recommendationsContainsIgnoreCase("try: " + expected1));
        assertTrue(beerRecommendationPage.recommendationsContainsIgnoreCase("try: " + expected2));
    }
}
