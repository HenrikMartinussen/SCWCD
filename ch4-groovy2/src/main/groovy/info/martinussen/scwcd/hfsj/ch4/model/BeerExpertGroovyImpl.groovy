package info.martinussen.scwcd.hfsj.ch4.model
class BeerExpertGroovyImpl implements BeerExpert {

	def  log = Logger.getLogger BeerExpertGroovyImpl.class

	@Override
	public List<String> getBrands(String color) {
		log.debug "BeerExpertGroovyImpl.getBrands() is called, parameter color was: ${color}"
		def brands = []
		if (color == 'amber') {
			brands << 'Jack Amber'
			brands << 'Red Moose'
		} else {
			brands << 'Jail Pale Ale'
			brands << 'Gout Stout'
		}
		log.debug "BeerExpertGroovyImpl.getBrands() returns: ${brands}"
		return brands // necessary because of log.debug being the last line in the method
	}

}
