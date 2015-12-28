package Tiles;

public enum Directions {
		UP("up"),DOWN("down"),RIGHT("right"),LEFT("left");
		
		private String direction;
		
		private Directions(String direction) {
			this.direction = direction;
		}
		
		public String getDirection(){
			return this.direction;
		}
}
