import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert

BeerExpert expert = context.getAt("beerExpert")
assert expert != null
color = params.color ?: 'amber'
def brands = []
brands =  expert.getBrands(color)
assert brands.size() > 0
println '<html>'
println '<body>'
println '<h1 align="center">Beer recommendations</h1>'
println '<p>'
brands.each{
  println "<br/>Try: ${it}"
}
println '</p>'
println '</body>'
println '</html>'
