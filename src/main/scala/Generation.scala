package de.numrich.gameoflife

class Generation(val aliveCells: Set[Cell] = Set.empty) {
	require (aliveCells != null, "aliveCells must not be null!") 

	private def aliveNeighbours(cell: Cell) =
		cell.neighbours filter aliveCells.contains
	
	private def deadNeighbours(cell: Cell) =
		cell.neighbours filter {neighbour => !(aliveCells contains neighbour)}
	
	def next: Generation = {
		val stayingAlive  = aliveCells filter { 2 to 3 contains aliveNeighbours(_).size }
		val wakingFromDead = aliveCells flatMap deadNeighbours filter { aliveNeighbours(_).size == 3 }
		new Generation(stayingAlive ++ wakingFromDead)
	}
}


