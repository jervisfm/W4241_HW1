
public class MatrixLib {

	/**
	 * Does Matrix Multiplication using Strassen Algorithm 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Matrix strasMult(Matrix a, Matrix b) {
		
		// to be implemented
		return null; 
	}
	
	/**
	 * Performs Matrix Multiplication using the traditional
	 * (naive) algorithm. 
	 * 
	 * @param a - matrix A
	 * @param b - Matrix B
	 * @return Matrix A multiplied by Matrix b, or 
	 * NULL if an error occurs. 
	 */
	public static Matrix mult(Matrix a, Matrix b) {
		
		// Check inputs
		if (!MatrixUtil.canMultiply(a, b) ||
			a == null || b == null)
			return null;
		
		
		return null; 
		
	}
}
