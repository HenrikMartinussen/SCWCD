package info.martinussen.scwcd.hfsj.ch4.model

import org.apache.log4j.Logger

class BeerExpert{
 
	def  log = Logger.getLogger(BeerExpert.class)

	public List<String> getBrands(String color) {
		log.debug "BeerExpert.getBrands() is called, parameter color was: ${color}"
		def brands = []
		if (color == 'amber') {
			brands << 'Jack Amber'
			brands << 'Red Moose'
		} else {
			brands << 'Jail Pale Ale'
			brands << 'Gout Stout'
		}
		log.debug "BeerExpert.getBrands() returns: ${brands}"
		return brands // necessary because of log.debug being the last line in the method
	}

}
