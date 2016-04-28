package assignment7;

import java.util.ArrayList;

public class Color {
	String color1 = "red";
	String color2 = "blue";
	String color3 = "orange";
	String color4 = "green";
	String color5 = "yellow";
	String color6 = "purple";
	ArrayList<String> colors;
	public Color(){
		colors = new ArrayList<String>();
		colors.add(color1);
		colors.add(color2);
		colors.add(color3);
		colors.add(color4);
		colors.add(color5);
		colors.add(color6);
	}
	
	public void setColor(int spot, String replacementColor){
		colors.set(spot, replacementColor);
	}
	
	public String get(int index){
		switch(index){
		case 1: return "blue";
		case 4: return "yellow";
		case 3: return "green";
		case 0: return "red";
		case 5: return "purple";
		case 2: return "orange";
		}
		return null;
	}
	
	public String getColor(String color) {
		switch(color){
		case "B": return "blue";
		case "Y": return "yellow";
		case "G": return "green";
		case "R": return "red";
		case "P": return "purple";
		case "O": return "orange";
		}
		return "incorrect input";
	}
}
