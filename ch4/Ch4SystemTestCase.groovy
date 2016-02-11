package info.martinussen.scwcd.hfsj.ch4.integration
@Grab(group='info.martinussen.scwcd.hfsj', module='ch4', version='1.0-SNAPSHOT', classifier='classes')

import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerRecommendationPage
import info.martinussen.scwcd.hfsj.ch4.testdriver.ColorSelectionPage

class SystemTestCase extends GroovyTestCase {

	def url = "http://localhost:8081/ch4"
	
	ColorSelectionPage colorSelectionPage
	
	void setUp(){
		colorSelectionPage = new ColorSelectionPage(url)
		assert colorSelectionPage.titleContainsIgnoreCase('Beer Selection Page')
	}
	
	void testCh4WhenSelectingColorLight(){
		colorSelectionPage.selectColor(ColorSelectionPage.COLOR_LIGHT)
		BeerRecommendationPage beerRecommendationPage = colorSelectionPage.clickSubmit()
		assert beerRecommendationPage.titleContainsIgnoreCase('Beer recommendations')
        assert beerRecommendationPage.headerContainsIgnoreCase('Beer Recommendations JSP')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Jail Pale Ale')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Gout Stout')
	}
	
	void testCh4WhenSelectingColorBrown(){
		colorSelectionPage.selectColor(ColorSelectionPage.COLOR_BROWN)
		BeerRecommendationPage beerRecommendationPage = colorSelectionPage.clickSubmit()
		assert beerRecommendationPage.titleContainsIgnoreCase('Beer recommendations')
        assert beerRecommendationPage.headerContainsIgnoreCase('Beer Recommendations JSP')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Jail Pale Ale')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Gout Stout')
	}

	void testCh4WhenSelectingColorDark(){
		colorSelectionPage.selectColor(ColorSelectionPage.COLOR_DARK)
		BeerRecommendationPage beerRecommendationPage = colorSelectionPage.clickSubmit()
		assert beerRecommendationPage.titleContainsIgnoreCase('Beer recommendations')
        assert beerRecommendationPage.headerContainsIgnoreCase('Beer Recommendations JSP')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Jail Pale Ale')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Gout Stout')
	}	
	
	void testCh4WhenSelectingColorAmber(){
		colorSelectionPage.selectColor(ColorSelectionPage.COLOR_AMBER)
		BeerRecommendationPage beerRecommendationPage = colorSelectionPage.clickSubmit()
		assert beerRecommendationPage.titleContainsIgnoreCase('Beer recommendations')
        assert beerRecommendationPage.headerContainsIgnoreCase('Beer Recommendations JSP')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Jack Amber')
        assert beerRecommendationPage.recommendationsContainsIgnoreCase('try: Red Moose')
	}

}