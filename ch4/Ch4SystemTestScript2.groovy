@Grab(group='info.martinussen.scwcd.hfsj', module='ch4', version='1.0-SNAPSHOT', classifier='classes')
import info.martinussen.scwcd.hfsj.ch4.testdriver.BeerRecommendationTestFixture

def testCases = [] //groovy way of defining an empty List

// adding four maps of parameters and expected recommendations to the List of testCases
testCases << [color:'amber', adviceContainsGoutStout:false, adviceContainsJailPaleAle:false, adviceContainsJackAmber:true,  adviceContainsRedMoose:true]
testCases << [color:'light', adviceContainsGoutStout:true,  adviceContainsJailPaleAle:true,  adviceContainsJackAmber:false, adviceContainsRedMoose:false]
testCases << [color:'brown', adviceContainsGoutStout:true,  adviceContainsJailPaleAle:true,  adviceContainsJackAmber:false, adviceContainsRedMoose:false]
testCases << [color:'dark',  adviceContainsGoutStout:true,  adviceContainsJailPaleAle:true,  adviceContainsJackAmber:false, adviceContainsRedMoose:false]


testCases.each { testCase ->
    def fixture = new BeerRecommendationTestFixture()
    fixture.color = testCase.color
    assert fixture.fetchAdvice() 
    assert fixture.adviceContainsGoutStout()   == testCase.adviceContainsGoutStout
    assert fixture.adviceContainsJailPaleAle() == testCase.adviceContainsJailPaleAle
    assert fixture.adviceContainsJackAmber()   == testCase.adviceContainsJackAmber
    assert fixture.adviceContainsRedMoose()    == testCase.adviceContainsRedMoose
	println "${testCase.toString().padRight(130, '.')} OK"
}

