package info.martinussen.scwcd.hfsj.ch4.integration
@Grab(group='info.martinussen.scwcd.hfsj', module='ch4', version='1.0-SNAPSHOT', classifier='classes')

import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerRecommendationPage
import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerSelectionPage

class Ch4SystemTestCase extends GroovyTestCase {

    def beerSelectionPage
    
    def testCases = [] //groovy way of defining an empty List
	
	void setUp(){ // adding four maps of parameters and expected recommendations to the List of testCases
		testCases << [color:'amber', expected1:'try: Jack Amber',    expected2:'try: Red Moose']
		testCases << [color:'light', expected1:'try: Jail Pale Ale', expected2:'try: Gout Stout']
		testCases << [color:'brown', expected1:'try: Jail Pale Ale', expected2:'try: Gout Stout']
		testCases << [color:'dark',  expected1:'try: Jail Pale Ale', expected2:'try: Gout Stout']
    }
	
	
    void testCh4(){
		testCases.each { testCase ->
			def beerSelectionPage = BeerSelectionPage.showPage('http://localhost:8081/ch4')
			assert beerSelectionPage.title =~ 'Beer Selection Page'
			
			beerSelectionPage.selectColor(testCase.color)
			def beerRecommendationPage =  beerSelectionPage.clickSubmit()
			
			assert beerRecommendationPage.title           =~ 'Beer recommendations'
			assert beerRecommendationPage.header          =~ 'Beer recommendations JSP'
			assert beerRecommendationPage.recommendation  =~ testCase.expected1
			assert beerRecommendationPage.recommendation  =~ testCase.expected2
		}
    }
}