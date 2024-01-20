
public class TestSudokuHidden {

	public static void main(String[] args) {
		
		int[][] g1 = new int[][] {
			{1, 2, 3, 4, 5, 6, 7, 8, 9},
			{4, 10, 6, 7, 8, 9, 1, 2, 3},
			{7, 8, 9, 1, 2, 3, 4, 5, 6},
			{2, 3, 4, 7, 6, 7, 8, 9, 1},
			{5, 6, 7, 8, 2, 1, 2, 3, 4},
			{8, 9, 1, 2, 3, 6, 5, 6, 7},
			{3, 4, 5, 6, 7, 8, 3, 1, 2},
			{6, 7, 8, 9, 1, 2, 3, 4, 5},
			{9, 1, 2, 3, 4, 5, 6, 7, 8}
		};
		
		int[][] g2 = new int[][] {
			{1, 2, 3, 4},
			{4, 3, 2, 1},
			{2, 1, 4, 3},
			{3, 4, 1, 2}
		};
		
		int[][] g3 = new int[][] {
			{2, 6, 9, 8, 7, 4, 3, 1, 5},
			{4, 3, 5, 6, 9, 1, 2, 7, 8},
			{8, 7, 1, 2, 3, 5, 4, 6, 9},
			{5, 2, 3, 4, 8, 6, 7, 9, 1},
			{6, 9, 7, 1, 2, 3, 5, 8, 4},
			{1, 4, 8, 9, 5, 7, 6, 2, 3},
			{3, 5, 6, 7, 1, 8, 9, 4, 2},
			{7, 1, 2, 3, 4, 9, 8, 5, 6},
			{9, 8, 4, 5, 6, 2, 1, 3, 7}
		};
		
		int[][] g4 = new int[][] {
			{4, 1, 2, 5, 3},
			{1, 3, 5, 4, 2},
			{2, 5, 1, 3, 4},
			{3, 2, 4, 5, 1},
			{5, 4, 3, 1, 2}
		};
		
		int[][] g5 = new int[][] {
			{8, 5, 9, 2, 1, 6, 4, 3, 7},
			{1, 4, 3, 7, 5, 9, 6, 8, 2},
			{6, 7, 2, 8, 4, 3, 9, 1, 5},
			{7, 3, 1, 5, 6, 2, 8, 4, 9},
			{9, 2, 6, 4, 3, 8, 7, 5, 1},
			{4, 8, 5, 1, 9, 7, 2, 6, 3},
			{3, 9, 4, 6, 7, 5, 1, 2, 8},
			{2, 6, 7, 3, 8, 1, 5, 9, 4},
			{5, 1, 8, 9, 2, 4, 3, 7, 6}
		};

		boolean b1, b2;
		
		Sudoku s1 = new Sudoku(g1);
		Sudoku s2 = new Sudoku(g2);
		Sudoku s3 = new Sudoku(g3);
		Sudoku s4 = new Sudoku(g4);
		Sudoku s5 = new Sudoku(g5);
		
		UniqueDiagonalSudoku u1 = new UniqueDiagonalSudoku(g1);
		UniqueDiagonalSudoku u2 = new UniqueDiagonalSudoku(g2);
		UniqueDiagonalSudoku u3 = new UniqueDiagonalSudoku(g3);
		UniqueDiagonalSudoku u4 = new UniqueDiagonalSudoku(g4);
		UniqueDiagonalSudoku u5 = new UniqueDiagonalSudoku(g5);
		
		// ---------- Test 1 ----------
		
		b1 = !s1.isValidSolution();
		b2 = !u1.isValidSolution();

		if (b1 && b2) {
			System.out.println("Test 1 Passed");
		} else {
			System.out.println("Test 1 Failed");
		}
		
		
		// ---------- Test 2 ----------
		
		b1 = s2.isValidSolution();
		b2 = u2.isValidSolution();

		if (b1 && b2) {
			System.out.println("Test 2 Passed");
		} else {
			System.out.println("Test 2 Failed");
		}
		
		
		// ---------- Test 3 ----------
		
		b1 = s3.isValidSolution();
		b2 = !u3.isValidSolution();

		if (b1 && b2) {
			System.out.println("Test 3 Passed");
		} else {
			System.out.println("Test 3 Failed");
		}
		
		
		
		// ---------- Test 4 ----------
		
		b1 = !s4.isValidSolution();
		b2 = !u4.isValidSolution();

		if (b1 && b2) {
			System.out.println("Test 4 Passed");
		} else {
			System.out.println("Test 4 Failed");
		}
		
		
		// ---------- Test 5 ----------
		
		b1 = s5.isValidSolution();
		b2 = u5.isValidSolution();

		if (b1 && b2) {
			System.out.println("Test 5 Passed");
		} else {
			System.out.println("Test 5 Failed");
		}
		
		
	}

}