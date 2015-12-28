package Tiles;

public class Position {
	
	int row;
	int col;
	
	public Position( int row, int col){
		this.row = row;
		this.col = col;	
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	@Override
	public String toString() {
		return "fila:" + this.row + " " + "columna:" + this.col;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		Position other = (Position)obj;
		return this.getRow() == other.getRow() && this.getCol() == other.getCol();
	} 
	

}
