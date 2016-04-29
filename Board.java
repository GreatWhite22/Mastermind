package assignment7;

public class Board {
	int columns;
	int rows;
	Code code = new Code();

	public Board(){
		this.columns = 4;
		this.rows = 12;
	}
	public Board(int numRows){
		this.rows = numRows;
		this.columns = 4;
	}
}