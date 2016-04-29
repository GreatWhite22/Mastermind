package assignment7;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.applet.Applet;

public class Game extends Applet implements Runnable{
	private Thread animate;
	private Board board;
	private Code code;
	private ArrayList<String> history;
	
	public void init(){
		board = new Board();
		code = board.code;
	}

	@Override
	public void run() {
		while(Thread.currentThread() == animate){
			if(begin()){
				history = new ArrayList<String>();
				play();
			}
			else{
				stop();
			}
		}
		
	}

	public void start(){
		this.animate = new Thread(this);
		this.animate.start();
	}

	public void stop(){
		this.animate = null;
	}
	
	public Boolean begin(){
		String pt1 = "<html><body width ='";
		String pt2 = "'><h1>Welcome to Mastermind!<h1>" + "<p>Here are the rules. This is a text version of the classic board game Mastermind." + 
" The computer will think of a secret code. The code consists of 4 colored pegs. The pegs may be one of six colors: blue, green, orange, purple, red, or yellow. " +
				"A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in." + 
" After you make a valid guess the result (feedback) will be displayed. The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess." +
				 " For each peg in the guess that is the correct color, but is out of position, you get a white peg.  For each peg, which is fully incorrect, you get no feedback." +
" Only the first letter of the color is displayed. B for Blue, R for Red, and so forth. When entering guesses you only need to enter the first character of each color as a capital letter." +
" You have 12 guesses to figure out the secret code or you lose the game.<br><br>" + 
"Are you ready to play?<p>";
		JPanel p = new JPanel(new BorderLayout());
		String s = pt1 + 500 + pt2;		
		int play = JOptionPane.showConfirmDialog(null,s,"Welcome", JOptionPane.YES_NO_OPTION);
		if(play == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void play(){
		String[] guess;
		Boolean victory = false;
		JOptionPane.showMessageDialog(null, "...Generating secret code...");
		for(int i = 12; i > 0; i--){
			String s = JOptionPane.showInputDialog("You have " + i + " guesses left\n" +
				"What is your next guess?\n" + 
				"Type in the characters for your guess or type history to see previous guesses", "Enter your guess");
			if ((s != null) && (s.length() > 0)){
				if(s.equals("history")){
					if(history.isEmpty()){
						JOptionPane.showMessageDialog(null, "You've made no guesses yet");
						i++;
						continue;
					}
					String completeHistory = history.toString().replaceAll("\\[", "").replaceAll("\\]","").replaceAll(",", "");
					JOptionPane.showMessageDialog(null, completeHistory);
					i++;
					continue;
				}
				s = s.toUpperCase();
				s = s.replaceAll("\\s+","");
				guess = s.split("(?!^)");
				if(guess.length == 4){
					Boolean validInput = true;
					for(int j = 0; j < 4; j++){
						if("incorrect input" == code.colors.getColor(guess[j])){
							validInput = false;
						}
					}
					if(validInput){
						history.add(s);
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect input enter 4 characters (R,B,G,O,Y,P)");
						i++;
						continue;
					}
				}
				int[] bw = code.checkGuess(guess);
				if(bw[0] == 4){
					JOptionPane.showMessageDialog(null, bw[0] + " black\n" + "You Win!");
					victory = true;
					break;
				}
				else{
					JOptionPane.showMessageDialog(null, bw[0] + " black " + bw[1] + " white");
					history.add(bw[0] + " black " + bw[1] + " white\n");
				}
			}
			else{
				stop();
				break;
			}
		}
			if(!victory){
				JOptionPane.showMessageDialog(null, "Sorry you didn't win here is the correct code" + code.colorCode);
			}
			if(0 == JOptionPane.showConfirmDialog(null,"Would you like to play again?", "Mastermind", JOptionPane.YES_NO_OPTION)){
				start();
				run();
			}
			else{
				stop();
			}
	}
}
