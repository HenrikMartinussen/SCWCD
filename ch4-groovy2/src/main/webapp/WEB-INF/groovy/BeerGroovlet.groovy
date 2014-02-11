import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert

BeerExpert expert = context.getAt("beerExpert")
assert expert != null
color = params.color ?: 'amber'
def brands = []
brands =  expert.getBrands(color)
assert brands.size() > 0

html.expandEmptyElements=false
response.contentType = 'text/html'
html.html{
  head{
    title 'Beer Recommendations'
  }
  body {
    h1(align="center") {'Beer Recommendations'}
    p {
      brands.each{ brand ->
        br()
        print "Try: ${brand}"
      }
    }
  }
}

