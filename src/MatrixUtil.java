
public class MatrixUtil {

	public static int rowSize(Matrix m) {
		return m.data().length; 
	}
	
	public static int colSize(Matrix m) {
		return m.data()[0].length;
	}
	
	public static boolean canMultiply(Matrix a, Matrix b) {
		return a.colSize() == b.rowSize(); 
	}
	
	/**
	 * Checks if a dot product can be performed between 'a' and 'b'
	 * @param a - must a ROW vector
	 * @param b - must be a ROW vector
	 * @return true if dot product can be computed
	 */
	public static boolean canDotProduct(Matrix a, Matrix b) {
		return  a.colSize() == b.colSize() &&
				a.rowSize() == 1 && b.rowSize() == 1;
	}
	
	public static boolean isSameSize(Matrix a, Matrix b) {
		return  a.rowSize() == b.rowSize() &&
			    a.colSize() == b.colSize();
	}
	
	/**
	 * Determines if Matrices 'a' and 'b' are square matrices
	 * and that they have the same dimension.
	 */
	public static boolean isSameSizeSquareMatrix(Matrix a, Matrix b) {
		int size = a.rowSize(); 
		return  a.colSize() == size && 
				b.rowSize() == size && b.colSize() == size; 
	}
	
	/**
	 * Ensures that the given matrices are 2x2 matrices.
	 * @param a - matrix A
	 * @param b - matrix B
	 * @return true if both are 2x2
	 */
	public static boolean isTwoByTwo(Matrix a, Matrix b) {
		final int size = 2;
		return  a.rowSize() == size && a.colSize() == size &&
				b.rowSize() == size && b.colSize() == size;
	}
	
	/**
	 * Gets the sub-matrix at the given position assuming that
	 * the current matrix is divided into 4 equal block matrices.
	 * The Indices are 0-based.   
	 * @param row - row index
	 * @param col - column index
	 * @return
	 */
	public static Matrix getMat(Matrix m, int row, int col) throws Exception {
		
		if (m.rowSize() != m.colSize()) 
			throw new Exception("Matrix must be a square matrix");
		
		if ((row != 0 && row != 1) ||
			(col != 0 && col != 1))
			throw new Exception("Invalid Indexes Given: " + row + "," + col);
					
		int size = m.rowSize();
		
		double lg2 = Math.log10(size) / Math.log10(2);
		double lg2flr = Math.floor(lg2);
		double diff = Math.abs(lg2 - lg2flr);
		if (diff >= Math.pow(10, -9))
			throw new Exception("Matrix dimension should be a power of 2");
		
		int newMatSize = (int) Math.ceil(size / 2);
		Matrix result = new Matrix(newMatSize, newMatSize); 
		
		int startRow, endRow;
		int startCol, endCol;
		startRow = endRow = startCol = endCol = 0;
		
		if (row == 0 && col == 0 ) {
			startRow = 0; endRow = newMatSize;
			startCol = 0; endCol = newMatSize;
		} else if (row == 0 && col == 1) {
			startRow = 0; endRow = newMatSize;
			startCol = newMatSize; endCol = size; 
		} else if (row == 1 && col == 0) {
			startRow = newMatSize; endRow = size;
			startCol = 0; endCol = newMatSize;
		} else if (row == 1 && col == 1) {
			startRow = startCol = newMatSize; 
			endRow = endCol = size;
		}
		
		for (int i = startRow, r = 0; i < endRow; ++i, ++r) {
			for (int j = startCol, c = 0; j < endCol; ++j, ++c) {
				double val = m.get(i, j);
				result.set(r, c, val);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param a - a ROW Vector
	 * @param b - a ROW Vector
	 * @return
	 * @throws Exception
	 */
	public static double dotProduct(Matrix a, Matrix b) throws Exception {
		
		// Check inputs
		if (a == null || b == null)
			throw new Exception("Null input given");
		
		if (!canDotProduct(a, b))
			throw new Exception("Given Matrices are not Equal Sized " +
								"Row Vectors"); 
		
		int size = a.colSize(); 
		double sum = 0;
		for (int i = 0; i < size; ++i) {			
			sum += a.get(0, i) * b.get(0, i);
		}
		return sum;
	}
	
	
	
	
}
