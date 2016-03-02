package info.martinussen.scwcd.hfsj.ch4.integration;

import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerRecommendationPage;
import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerSelectionPage;
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

    BeerSelectionPage beerSelectionPage;

    @Parameterized.Parameters
    public static Collection<String[]> getTestParameters(){
        return Arrays.asList(new String[][]{
              // testColor,                     expected1,       expected2
                {BeerSelectionPage.COLOR_AMBER, "Jack Amber",    "Red Moose"},
                {BeerSelectionPage.COLOR_LIGHT, "Jail Pale Ale", "Gout Stout"},
                {BeerSelectionPage.COLOR_BROWN, "Jail Pale Ale", "Gout Stout"},
                {BeerSelectionPage.COLOR_DARK,  "Jail Pale Ale", "Gout Stout"}
        });
    }

    public Ch4ITCase(String testColor, String expected1, String expected2){
        this.testColor = testColor;
        this.expected1 = expected1;
        this.expected2 = expected2;
    }

    @Before
    public void setUp(){
        beerSelectionPage = BeerSelectionPage.showPage("http://localhost:8081/ch4");          // Obtain page abstraction instance
        assertTrue(beerSelectionPage.getTitle().contains("Beer Selection Page"));             // Validate page property contents
    }

    @Test
    public void testCh4(){                                                                    // Called once for each parameter list item
        beerSelectionPage.selectColor(testColor);                                             // Choose the test color in the drop-down
        BeerRecommendationPage beerRecommendationPage = beerSelectionPage.clickSubmit();      // Click submit and receive the resulting page
        assertTrue(beerRecommendationPage.getTitle().contains("Beer recommendations"));       // Validate page property contents
        assertTrue(beerRecommendationPage.getHeader().contains("Beer recommendations JSP"));
        assertTrue(beerRecommendationPage.getRecommendation().contains("try: " + expected1)); // Validate recommendation contents
        assertTrue(beerRecommendationPage.getRecommendation().contains("try: " + expected2));
    }
}
