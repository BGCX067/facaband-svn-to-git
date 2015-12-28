package Tiles;

import java.lang.Iterable;
import java.util.Iterator;



public class Board implements Iterable<Tile>{
	public Tile[][] board;
	
	Tile[] tile = new Tile[3];
	SokobanGuy sGuy;
	Box sBox;
	
	
	public Board(int rows, int cols) {
		this.board = new Tile[rows][cols];
		this.sGuy = new SokobanGuy(2,2);
		this.sBox = new Box(3,3);
		initializeBoard();
		tile[0] = new EmptyTile();
		tile[1] = new Wall();
		tile[2] = new Goal();
		board[2][2].moveable = sGuy;
		board[3][3].moveable = sBox;
	}
	
	public int getRows(){
		return board.length;
	}
	
	public int getCols(){
		return board[0].length;
	}
	
	public Tile getTile(Position pos ) {
		return getTile(pos.getRow(), pos.getCol());
	}
	
	public Tile getTile(int row, int col){
		return board[row][col];
	}
	
	public void setTile(int row, int col, Tile aTile) {
		board[row][col] = aTile;
	}
	
	public void setMoveablePiece(Position position, Moveable aMoveable) {
		board[position.getRow()][position.getCol()].moveable = aMoveable;
		aMoveable.i=position.getRow();
		aMoveable.j=position.getCol();
	}
	
	public void setTile(Position position, Tile aTile) {
		setTile(position.getRow(), position.getCol(), aTile);
	}
	
	public void getScore(){
//		Despues hay que difinir aca como sumas puntaje por la jugada.
	}
	
	public boolean isValidPosition(Position pos) {
		return isValidPosition(pos.getRow(), pos.getCol()) ;
	}
	
	public boolean isValidPosition(int row, int col) {
		return ( row >= 0 & row < this.getRows() ) && ( col >= 0 & col < this.getCols() ) ;
	}
	
	public void initializeBoard(){
		for(int i = 0; i < this.getRows(); i++){
			for(int j = 0; j < this.getCols(); j++){
				if(i==0){
					this.setTile( i, j, new Wall());
				} else if(i==1 && (j%2 == 0) ){
					this.setTile( i, j, new Goal());
				}else{
					this.setTile( i, j, new EmptyTile());
				}
			}
		}
	}
	
	public boolean movesGuy(Position target) {
		Tile tgtPiece = getTile(target);
		if(tgtPiece.isEmpty()){
			board[sGuy.i][sGuy.j].moveable = null;
			this.setMoveablePiece(target,sGuy);
			return true;
		}
		if(tgtPiece.moveable instanceof Box){
			int sumari = Math.abs(sGuy.i - target.getRow());
			int sumarj = Math.abs(sGuy.j - target.getCol());
			target.row = target.row + sumari;
			target.col = target.col + sumarj;
			movesBox(target);
		}
		return false;
	}
	
	public boolean movesBox(Position target) {
		Tile tgtPiece = getTile(target);
		if(tgtPiece.isEmpty()){
			board[sBox.i][sBox.j].moveable = null;
			this.setMoveablePiece(target,sBox);
			return true;
		}
		return false;
	}
	
	
	public void printBoard(){
		for(int i = 0; i < this.getRows(); i++){
			for(int j = 0; j < this.getCols(); j++){
				if ( board[i][j].moveable == null){
					System.out.printf("%s\t", board[i][j]);
				}else{
					System.out.printf("%s\t", board[i][j].moveable);
				}

			}
			System.out.println("");
		}
	}
	
//	ITERATOR  >>> TODAVIA NO ESTA PROBADO!
	
	@Override
	public Iterator<Tile> iterator() {
		return new BoardIterator();
	}
	
	private class BoardIterator implements Iterator<Tile> {
		
		private int i,j;
		
		@Override
		public boolean hasNext() {
			return Board.this.isValidPosition(i, j);
		}
		
		@Override
		public Tile next() {
			Tile tile = Board.this.getTile(i,j);
			if( ++j == Board.this.getCols()) {
				j=0; i++;
			}
			return tile;	
		}
		
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	}
	
//	MAIN
	
	public static void main(String[] args) {
		Board board = new Board(5,5);
		board.printBoard();
		Position posicion1 = new Position(3,2);
		Position posicion2 = new Position(3,3);
		Position posicion3 = new Position(4,3);
		board.movesGuy(posicion1);
		System.out.println("");
		board.printBoard();
		board.movesGuy(posicion2);
		System.out.println("");
		board.printBoard();
		board.movesGuy(posicion3);
		System.out.println("");
		board.printBoard();
	}

}
