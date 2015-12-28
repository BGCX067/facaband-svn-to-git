package Tiles;

public class Tile {
	protected Moveable moveable;
	
	public Tile(){
		moveable = null;
	}
	
	public Tile(Moveable moveable){
		this.moveable = moveable;
	}
	
	public boolean isEmpty(){
		return true;
	}
	
	public Moveable getMoveable() {
			return moveable;
	}
	
	public void putBox(Box box){
		this.moveable = box;
	}
	
	public void putPlayer(SokobanGuy player){
		this.moveable = player;
	}
	
	public void removeFromTile(){
		this.moveable = null;
	}
}
