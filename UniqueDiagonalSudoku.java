
/**
 * The UniqueDiagonalSudoku class as a constructor with the 2d array numbers and uses the super method the call the numbers array from
 * class Sudoku which it extends. The isValidSolution checks if the Sudoku is valid from class Sudoku using super and all checks is the 
 * atleast one diagonal on the Suduko is valid using the private helper method isValidDiagonal. This method checks both diagonals from 
 * top-left to bottom-right and from bottom-left to top-right. If one of these diagonals is valid meaning it contains numbers from 1-size
 * exactly once, isValidDiagonal returns as true resulting in isValidSolution to return as true.
 * @author aryaz
 */

public class UniqueDiagonalSudoku extends Sudoku //class UniqueDiagonalSudoku extends class Sudoku
{
	public UniqueDiagonalSudoku (int[][] numbers) /** @param 2d array numbers of all digits in Sudoku **/
	{
		super(numbers); //super used to call numbers from Sudoku
	}
	
	public boolean isValidSolution() //returns if Sudoku and diagonal are valid
	{
		boolean SudokuValid = super.isValidSolution(); //calls isValidSolution from Sudoku class
		boolean diagonalValid = isValidDiagonal(); //boolean for private helper method below
		
		return (SudokuValid && diagonalValid); /** @return true if both booleans are true, false if otherwise **/
	}
	
	private boolean isValidDiagonal() //private helper to check both diagonals of sudoku
	{
		int size = getSize();//size of grid using getter from parent
		int[][]grid = getGrid(); //copy of grid from parent
		
		boolean firstDiagonal = true; //check from top-left to bottom-right 
		boolean[] checkFirst = new boolean[size]; //checks that all digits appear once
		
		int firstNumber = 0;
		
		for(int i = 0; i < size; i++) //for loops from bottom left to top right goes (0,0), (1,1), (2,2) ... (size-1,size-1)
		{
			firstNumber = grid[i][i]; //digit being checked
			
			if (firstNumber < 1 || firstNumber > size || checkFirst[firstNumber -1]) //checks if digit is in size range and appears exactly once
			{
				firstDiagonal = false; /**@return false if any of the conditions are met **/
				break;
			}
			checkFirst[firstNumber - 1] = true; //establishes number as seen
		}
	
		//same logic used for second diagonal except now its checked from bottom left to top-left to bottom right
		boolean secondDiagonal = true; //check from bottom-left to top-right
		boolean[] checkSecond = new boolean[size];
		
		int secondNumber = 0;
		int row = size - 1; //row now starts at top left
		
		for(int i = 0; i < size; i++) 
		{
			secondNumber = grid[row][i]; //loops from (size-1,0), (size-2,1), (size-3,2) ... (0,size-1)
			
			if (secondNumber < 1 || secondNumber > size || checkSecond[secondNumber -1])
			{
				secondDiagonal = false;
				break;
			}
			
			checkSecond[secondNumber - 1] = true;
			row--; //decrease row by one every loop
		}
		return firstDiagonal || secondDiagonal; /** @return first diagonal OR second diagonal, only one has to be true to meet condition of true
		if both are false then false is returned **/
	}
}