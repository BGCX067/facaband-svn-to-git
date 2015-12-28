package Paquete1;

public class Player implements Comparable<Player>{
	
	String name;
	int score;
	
	public Player(String name, int score){
		this.setName(name);
		this.setScore(score);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName( String name){
		this.name = name;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	
	@Override
	public int hashCode() {
		return name.hashCode() + score;
	}
	
	@Override
	public boolean equals(Object obj) {
		Player other = (Player)obj;
		return this.name == other.getName() && this.score == other.getScore(); 
	}
	
	@Override
	public String toString() {
		return "Nombre:" + this.getName() + "Score:" + this.getScore();
	}
	
	@Override
	public int compareTo(Player other) {
		
		if ( this.getScore() > other.getScore() )
			return 1;
		
		if ( this.getScore() < other.getScore() ) 
			return -1;
		
		return ( this.getName().compareTo(other.getName()) );
	}
	
	
	
	
}
