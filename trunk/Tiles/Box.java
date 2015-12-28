package Tiles;

import Paquete1.Color;
import Paquete1.Colorable;

public class Box extends Moveable implements Colorable{
	
	Color colors;
	
	public Box(int i, int j){
		super(i,j);
	}
	
	public Box(int i, int j, int r,int g, int b){
		super(i,j);
		colors = new Color(r,g,b);
	}
	
	public Color getColor() {
		return colors;
	}
	
	@Override
	public String toString() {
		return "7";
	}
	
	
	

}
