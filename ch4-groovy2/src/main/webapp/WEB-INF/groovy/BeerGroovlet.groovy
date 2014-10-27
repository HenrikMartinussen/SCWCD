package info.martinussen.scwcd.hfsj.ch4.web
import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert
import org.apache.log4j.Logger

def  log = Logger.getLogger(BeerGroovlet.class)

log.debug "In BeerGroovlet, 'doPost'"

BeerExpert expert = context.getAt("beerExpert")
assert expert != null
color = params.color ?: 'amber'

log.debug "In BeerGroovlet, parameter color was $color"

def brands =  expert.getBrands(color)
assert brands.size() > 0

log.debug "In BeerGroovlet, expert returned $brands"

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

