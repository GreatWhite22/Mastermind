package assignment7;

import java.util.ArrayList;
import java.util.Random;

public class Code {
	ArrayList<String> colorCode;
	Color colors;
	Code(){
		colorCode = new ArrayList<String>();
		colors = new Color();
		Random color = new Random();
		for(int i = 0; i < 4; i++){
			colorCode.add(colors.get(color.nextInt(6)));
		}
	}
	
	Code(int Col){
		colorCode = new ArrayList<String>();
		colors = new Color();
		Random color = new Random();
		for(int i = 0; i < Col; i++){
			colorCode.add(colors.get(color.nextInt(6)));
		}
	}
	
	public int[] checkGuess(String[] guess){
		int[] bw = new int[2];
		ArrayList<String> code = new ArrayList<String>(colorCode);
		int guessLength = guess.length;
		int black = 0;
		int white = 0;
		for(int i = 0; i < guessLength; i++){
			if(code.get(i) == colors.getColor(guess[i])){
				guess[i] = "removed";
				code.set(i, null);
				black++;
			}
		}
		bw[0] = black;
		for(int i = 0; i < guessLength; i++){
			if(code.contains(colors.getColor(guess[i]))){
				code.set(code.indexOf(colors.getColor(guess[i])), null);
				white++;
			}			
		}
		bw[1] = white;
		return bw;
	}
}
