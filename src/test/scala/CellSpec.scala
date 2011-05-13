package de.numrich.gameoflife

import org.specs.Specification

class CellSpec extends Specification {
	"A Cell" should {
		"have eight neighbours" in {
			Cell(0,0).neighbours must haveSize(8)
		}
	}
}

