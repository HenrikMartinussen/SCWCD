package info.martinussen.scwcd.hfsj.ch4.integration
@Grab(group='info.martinussen.scwcd.hfsj', module='ch4', version='1.0-SNAPSHOT', classifier='classes')

import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerRecommendationPage
import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerSelectionPage

class Ch4SystemTestCase extends GroovyTestCase {

    def url = "http://localhost:8081/ch4"
    
    BeerSelectionPage beerSelectionPage
    
    void setUp(){
        beerSelectionPage = BeerSelectionPage.showPage(url)
        assert beerSelectionPage.title =~ 'Beer Selection Page'
    }
	
    void tearDown(){
        beerSelectionPage = null
    }
    
    void testCh4WhenSelectingColorLight(){
        beerSelectionPage.selectColor(BeerSelectionPage.COLOR_LIGHT)
        BeerRecommendationPage beerRecommendationPage =  beerSelectionPage.clickSubmit()
        assert beerRecommendationPage.title           =~ 'Beer recommendations'
        assert beerRecommendationPage.header          =~ 'Beer recommendations JSP'
        assert beerRecommendationPage.recommendation  =~ 'try: Jail Pale Ale'
        assert beerRecommendationPage.recommendation  =~ 'try: Gout Stout'
    }
    
    void testCh4WhenSelectingColorBrown(){
        beerSelectionPage.selectColor(BeerSelectionPage.COLOR_BROWN)
        BeerRecommendationPage beerRecommendationPage =  beerSelectionPage.clickSubmit()
        assert beerRecommendationPage.title           =~ 'Beer recommendations'
        assert beerRecommendationPage.header          =~ 'Beer recommendations JSP'
        assert beerRecommendationPage.recommendation  =~ 'try: Jail Pale Ale'
        assert beerRecommendationPage.recommendation  =~ 'try: Gout Stout'
    }

    void testCh4WhenSelectingColorDark(){
        beerSelectionPage.selectColor(BeerSelectionPage.COLOR_DARK)
        BeerRecommendationPage beerRecommendationPage =  beerSelectionPage.clickSubmit()
        assert beerRecommendationPage.title           =~ 'Beer recommendations'
        assert beerRecommendationPage.header          =~ 'Beer recommendations JSP'
        assert beerRecommendationPage.recommendation  =~ 'try: Jail Pale Ale'
        assert beerRecommendationPage.recommendation  =~ 'try: Gout Stout'
    }   
    
    void testCh4WhenSelectingColorAmber(){
        beerSelectionPage.selectColor(BeerSelectionPage.COLOR_AMBER)
        BeerRecommendationPage beerRecommendationPage =  beerSelectionPage.clickSubmit()
        assert beerRecommendationPage.title           =~ 'Beer recommendations'
        assert beerRecommendationPage.header          =~ 'Beer recommendations JSP'
        assert beerRecommendationPage.recommendation  =~ 'try: Jack Amber'
        assert beerRecommendationPage.recommendation  =~ 'try: Red Moose'
    }

}