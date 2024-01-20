/**
 * The Sudoku class is the first of two classes which is to be implemented for this assignment. The Sudoku class uses two 
 * private instance variables size and grid. Size is an int variable that tracks the length of the numbers 2d array parameter in the 
 * constructor. Grid is a 2d array (row and column) that is used for the Sudoku, shallow copied from the 2d array numbers. The other 
 * methods in the class consist of getters such as size, grid and digit. getSize returns the Sudoku board (in terms of total digits), 
 * getGrid returns the 2d array of the Sudoku grid, getDigitAt returns the value at a specific row and column. Additionally, there are 
 * five boolean methods: the first one validates if the specific row is a correct Sudoku row, the second one has the same purpose but
 * validates a specific column. The third one validates if a specific box (only for a 3x3 Sudoku because only 3x3 have 9 numbers) has 
 * all digits 1-9 exactly once. Is valid solution validates the enitre Sudoku board by checking if all the rows and columns from the
 *  previous isValidRow and isValidCol methods returned as true. The fifth method is an equals methods which compares if two Sudoku boards 
 *  share identical values and size. The last method is a toString method which returns the entire Sudoku board organized in shape and size 
 *  as a String.
 */

public class Sudoku 
{
	private int size; // private variable size of grid
	private int[][] grid; //private variable grid containing all the digits
	
	public Sudoku (int[][] numbers) /**@param the 2d array containing all the Sudoku digits **/
	{
		size = numbers.length; //size is length of numbers array
		grid = new int[size][size]; //grid is initialized with the length of size
		
		grid= numbers; //numbers is shallow copied to grid
	}
	
	public int getSize() //size getter
	{
		return size; /** @return the size of the grid **/
	}
	
	public int[][] getGrid() //grid getter
	{
		return grid; /** @return the grid of the Sudoku board **/
	}

	public int getDigitAt (int row, int col) //digit getter
	{
		if ( (row >= size || row < 0) || (col >= size || col < 0) ) //checks if row and column are in the dimensions of the grid
		{
			return -1; /** @return -1 if row or column is not in dimension **/
		}
		
		else
		{
			return grid[row][col]; /** @return digit at specific row and col after passing if test **/
		}
	}
	
	public boolean isValidRow (int row) /** validates specific row in @param **/
	{
		if (row >= size || row < 0) //checks if row is in dimension
		{
			return false; /** @return false if row does not exist **/
		}
		
		int number = 0; //number to store value from grid during check
		boolean[] check = new boolean[size]; //boolean array to check row
		/** the boolean check is the size of the number of rows and each index equals false. As the boolean is ran through the for loop
		 * at the end of the loop that number is checked off as true, in the if statement if the number is already marked as true the 
		 * row will be recognized as false (ex. number = 4, check[number - 1] = index 3 (spot of number 4) and index 3 = true.
		 * if in the for loop #4 appears again in the if statement check[4-1] will appear as true and false will be returned as 
		 * the row will be invalid.
		 */
		
		for(int i = 0; i < size; i++) //i to check all index of the row size
		{
			number = grid[row][i]; //number equals value in row
				
			if(number < 1 || number > size || check[number - 1]) //checks if number is from not from 1-size or check[number-1]is true
			{
				return false; /** @return false if any of the three instances are true**/
			}
			
			check[number - 1] = true; //make index that has been checked = true
		}
		
		for (int i = 0; i < size; i++)  //confirms that all numbers 1-size have been marked as true
		 {
			 if (!check[i]) 
			 {
				 return false; /**@return false if all numbers have not been seen **/
			 }
		 } 
		return true; /**@return true if both for loops were not false */
	}
	
	public boolean isValidCol (int col) /**validates specific column in @param **/
	{
		if (col >= size || col < 0) //checks if row is in dimension
		{
			return false; /** @return false if column does not exist **/
		}
		
		int number = 0; //number into to store value from grid during check
		boolean[] check = new boolean[size]; //boolean array to check column
		
		for(int i = 0; i < size; i++) //i to check all index of the col size
		{
			number = grid[i][col]; //number equals value in col
				
			if(number < 1 || number > size || check[number -1]) //checks if number is from not from 1-size or check[number-1]is true
			{
				return false; /** @return false if any of the three instances are true**/
			}
			
			check[number - 1] = true; //make index that has been checked = true
		}
		
		for (int i = 0; i < size; i++)  //confirms that all numbers 1-size have been marked as true
		 {
			 if (!check[i]) 
			 {
				 return false; /**@return false if all numbers have not been seen **/
			 }
		 }
		
		return true; /**@return true if both for loops were not false */
	}
	public boolean isValidBox (int row, int col) /** @param row and col of top left spot of 3x3 box in 9x9 grid **/
	{
		if ( (row > 6 || row < 0) || (col > 6 || col < 0) ) //top left corner of box therefore row/col can only be 0,3,6 index over 6 is out of range
		{
			return false; /**@return false if index is not one of the top left spot options **/
		}
		
		 boolean[] check = new boolean[9]; //check boolean array to validate each digit once
		 int number = 0; //int number to hold digit from array
		 
		 for (int i = row; i < row + 3; i++) //nested loop to go through the three rows of specific box
		 {
		        for (int j = col; j < col + 3; j++) //go through the 3 columns of specific box
		        {
		        	number = grid[i][j]; //number = value in grid (box)
		        	
		        	if(number < 1 || number > 9 || check[number -1]) //number - 1 #1 is index 0 9 is index 8
		        	{
		        		return false; /** @return false is number is out of range or repeated **/
		        	}       	
		        	
		        	check[number - 1] = true; //marks number as seen 
		        }
		 }
		 
		 for (int i = 0; i < 9; i++)  //validates that all numbers 1-9 have been marked as true
		 {
			 if (!check[i]) 
			 {
				 return false; /**@return false if all numbers 1-9 have not been seen **/
			 }
		 }

		    return true; /**@return true if box is valid **/
	}
	
	public boolean isValidSolution() //determines if entire sudoku grid is true
	{
		for(int i = 0; i < size; i++)//checks for all rows and columns in sudoku from 0-number of columns and rows
		{ 
			if (!isValidRow(i) || !isValidCol(i))
			{
				return false; /**@return false if a row or column is not valid */
			}
		}
		
		
		if(size == 9) //if sudoku size is 9
		{
			for(int row = 0; row < size; row+=3) //checks for rows and columns index 0,3,6 to check all three boxes
			{
				for(int col = 0; col < size; col+=3)
				{
					if(!isValidBox(row,col)) //checks if all 9 boxes are valid
					{
						return false; /**@return false if a box is invalid **/
					}
				}
			}
		}
		
		return true; /** @return true if all rows and columns are valid and all boxes are valid **/
	}
	
	public boolean equals(Sudoku other) /** compares two Sudokus to see if they are the same @param is other Sudoku **/
	{
		if(this.getSize() != other.getSize()) //compares the size of both grids
		{
			return false; /**@return false if both Sudokus are not the same size **/
		}
		
		int otherGrid[][] = other.getGrid(); // 2d array of other grid using getGrid
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++) //nested for loop to run through every digit of grids
			{
				if(this.grid[i][j] != otherGrid[i][j]) //compares this grid with the other grid
				{
					return false; /** @return false if a digit is different **/
				}
			}
		}
		
		return true;
	}
	
	public String toString() //returns string of sudoku board
	{
		String sudoku = ""; //sudoku string
		
		for(int row = 0; row < size; row++)
		{
			for(int col = 0; col < size; col++) //nested for loop to go through grid
			{
				sudoku += (grid[row][col]) + " "; //adds every digit in the Sudoku grid to the string with a space behind each number
			}
			sudoku += "\n"; //goes to next row after the row is done
		}
		return sudoku; /** @return sudoku gird **/
	}
}