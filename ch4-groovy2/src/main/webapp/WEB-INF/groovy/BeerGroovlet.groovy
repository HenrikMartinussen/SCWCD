package info.martinussen.scwcd.hfsj.ch4.web
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert
import org.apache.log4j.Logger

def  log = Logger.getLogger(BeerGroovlet.class)

log.debug("in BeerGroovlet, 'doGet'");

BeerExpert expert = context.getAt("beerExpert")
assert expert != null
color = params.color ?: 'amber'

log.debug("in BeerGroovlet, parameter color was $color");

def brands = []
brands =  expert.getBrands(color)
assert brands.size() > 0

brands.each{
  log.debug("in BeerGroovlet, expert returned brand $it");
}

html.expandEmptyElements=false
response.contentType = 'text/html'
html.html{
  head{
    title 'Beer Recommendations'
  }
  body {
    h1(align:"center",'Beer Recommendations')
    p {
      brands.each{ brand ->
        br()
        print "Try: ${brand}"
      }
    }
  }
}

