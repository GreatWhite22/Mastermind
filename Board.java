package assignment7;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	int columns;
	int rows;
	Code code = new Code();
	Peg pegs;

	public Board(){
		this.columns = 4;
		this.rows = 12;
	}
	public Board(int numRows){
		this.rows = numRows;
		this.columns = 4;
	}
}