package Tiles;

public class Goal extends Tile {
	
//	Aca habria que poner un enumerativo o algo que diga cuando un goal esta 
//	prendido o algo asi para llamar al objeto que esta en esa posicion y "encenderlo"
	public Goal(){
		super();
	}
	
	public boolean isEmpty(){
		if( moveable == null)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "2";
	}
}
