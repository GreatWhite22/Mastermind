package assignment7;

import java.util.ArrayList;
import java.util.Random;

public class Code {
	ArrayList<String> colorCode;
	Code(){
		colorCode = new ArrayList<String>();
		Color colors = new Color();
		Random color = new Random();
		for(int i = 0; i < 4; i++){
			colorCode.add(colors.get(color.nextInt(6)));
		}
	}
	
	public int[] checkGuess(String[] guess){
		int[] bw = new int[2];
		ArrayList<String> code = new ArrayList<String>(colorCode);
		//code = colorCode;
		Color checkColor = new Color();
		int guessLength = guess.length;
		int black = 0;
		int white = 0;
		for(int i = 0; i < guessLength; i++){
			if(code.get(i) == checkColor.getColor(guess[i])){
				code.set(i, null);
				black++;
			}
		}
		bw[0] = black;
		for(int i = 0; i < guessLength; i++){
			if(code.contains(checkColor.getColor(guess[i]))){
				code.set(code.indexOf(checkColor.getColor(guess[i])), null);
				white++;
			}			
		}
		bw[1] = white;
		return bw;
	}
}
