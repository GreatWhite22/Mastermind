package assignment7;

public class Board {
	int columns;
	int rows;
	Code code;

	public Board(){
		this.columns = 4;
		this.rows = 12;
		code = new Code();
	}
	
	public Board(int numCol, int numRows){
		this.rows = numRows;
		this.columns = numCol;
		code = new Code(columns);
	}	
}