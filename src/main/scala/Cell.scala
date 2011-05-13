package de.numrich.gameoflife
case class Cell(x: Int, y: Int) {

	def neighbours: Traversable[Cell] = 
		for {
			i <- (x-1 to x+1)
			j <- (y-1 to y+1) if(i!=x) || (j!=y)
		} yield Cell(i,j)

	override def toString = position

	private lazy val position = "(%s, %s)".format(x, y)
}
