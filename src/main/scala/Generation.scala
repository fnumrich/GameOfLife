package de.numrich.gameoflife

class Generation(val aliveCells: Set[Cell] = Set.empty) {
	require (aliveCells != null, "aliveCells must not be null!") 

	private def aliveNeighbours(cell: Cell) =
		cell.neighbours filter aliveCells.contains
	
	private def deadNeighbours(cell: Cell) =
		cell.neighbours filter {neighbour => !(aliveCells contains neighbour)}
	
	def next: Generation = {
		val stayingAlive  = aliveCells filter { 2 to 3 contains aliveNeighbours(_).size }
		val stayingAlive1 = aliveCells filter { cell => 2 to 3 contains aliveNeighbours(cell).size }
		val wakingFromDead = 
		new Generation(stayingAlive ++ wakingFromDead)
	}
}


