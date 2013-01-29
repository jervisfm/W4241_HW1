
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
