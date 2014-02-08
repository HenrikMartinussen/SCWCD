import info.martinussen.scwcd.hfsj.ch4.model.BeerExpert

BeerExpert expert = context.getAt("beerExpert")
assert expert != null
name = params.name ?: 'World'
println "Hello, $name!"