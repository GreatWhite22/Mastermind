package assignment7;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.applet.Applet;

public class Game extends Applet implements Runnable{
	private Thread animate;
	private Board board;
	private Code code;
	
	public void init(){
		board = new Board();
		code = board.code;
	}

	@Override
	public void run() {
		while(Thread.currentThread() == animate){
			if(begin()){
				play();
			}
			stop();
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
		String s = pt1 + 250 + pt2;		
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
		JOptionPane.showMessageDialog(null, "...Generating secret code...");
		for(int i = 12; i > 0; i--){
			String s = JOptionPane.showInputDialog("You have " + i + " guesses left\n" +
				"What is your next guess?\n" + 
				"Type in the characters for your guess", "Enter your guess");
			s = s.toUpperCase();
			guess = s.replaceAll("\\s+", "").split("(?!^)");
			int[] bw = code.checkGuess(guess);
			if(bw[0] == 4){
				JOptionPane.showMessageDialog(null, bw[0] + " black\n" + "You Win!");
			}
			else{
				JOptionPane.showMessageDialog(null, bw[0] + " black " + bw[1] + " white");
			}
		}
	}
}
