package Tiles;

public class Wall extends Tile{

	public Wall(){
		super();
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	@Override
	public String toString() {
		return "1";
	}
	
}
