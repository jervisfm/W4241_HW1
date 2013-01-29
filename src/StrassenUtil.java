
/**
 * 
 * @author Jervis
 * See http://en.wikipedia.org/wiki/Strassen_algorithm
 * for Algorithm details. 
 */
public class StrassenUtil {

	
	/**
	 * Performs Matrix Multiplication using the Strassen Algorithm
	 * on the given matrices.  
	 * @param a
	 * @param b
	 * @return
	 */
	public static Matrix multiply(Matrix a, Matrix b) throws Exception {
		// to be implemented. 
		
		if (!MatrixUtil.isSameSizeSquareMatrix(a, b))
			throw new Exception("Strassen Alg requires square Matrices");
		
		
		
		return null;
	}
	

	/**
	 * Does Matrix Multiplication using Strassen Algorithm assuming
	 * already that Matrix A and B have dimensions in the power of 2. 
	 * @param a
	 * @param b
	 * @return
	 * @throws Exception 
	 */
	private static Matrix strasMultHelper(Matrix a, Matrix b) throws Exception {
		

		if (a == null || b == null)
			throw new Exception("Null Matrix Input given");
		
		if (MatrixUtil.isTwoByTwo(a, b)) { /* Base Case */
			return mult2x2(a, b);
		} else { /* Recursive case */
			
			// Divide Matrix Up. 
			
			
		}
		return null; 
	}
	
	
	
	/**
	 * Does 2x2 Matrix multiplication (A * B) using the Strassen Alg
	 * @param a - Matrix A
	 * @param b - Matrix B
	 * @return the result of A * B
	 * @throws Exception if an error occurs.
	 */
	public static Matrix mult2x2(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");
		
		double c11 = Q1(a,b) + Q4(a,b) - Q5(a,b) + Q7(a,b); 
		double c21 = Q2(a,b) + Q4(a,b); 
		double c12 = Q3(a,b) + Q5(a,b);
		double c22 = Q1(a,b) + Q3(a,b) - Q2(a,b) + Q6(a,b);
		
		double[][] ans = {{c11, c12}, {c21, c22}};
		Matrix result = new Matrix(2,2); 
		result.set(ans);
		return result;
	}
	
	private static double Q1(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a11 = a.get1(1, 1);
		double a22 = a.get1(2, 2);
		double b11 = b.get1(1, 1);
		double b22 = b.get1(2, 2);

		double result = (a11 + a22) * (b11 + b22);
		return result;
	}
	
	private static double Q2(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a21 = a.get1(2,1);
		double a22 = a.get1(2,2);
		double b11 = b.get1(1,1);
		
		double result = (a21 + a22) * b11;  
		return result;
	}	
	
	private static double Q3(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a11 = a.get1(1,1);
		double b12 = b.get1(1,2); 
		double b22 = b.get1(2,2); 
		
		double result = a11 * (b12 - b22);   
		return result;
	}	
	
	private static double Q4(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a22 = a.get1(2,2); 
		double b11 = b.get1(1,1); 
		double b21 = b.get1(2,1); 
		
		double result = a22 * (-b11 + b21);  
		return result;
	}
	
	private static double Q5(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a11 = a.get1(1, 1);
		double a12 = a.get1(1,2);
		double b22 = b.get1(2,2); 
		
		double result = (a11 + a12) * b22;   
		return result;
	}
	
	private static double Q6(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a11 = a.get1(1,1);
		double a21 = a.get1(2,1);
		double b11 = b.get1(1,1);
		double b12 = b.get1(1,2);
		
		double result = (-a11 + a21) * (b11 + b12);  
		return result;
	}
	
	private static double Q7(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		double a12 = a.get1(1,2);
		double a22 = a.get1(2,2);
		double b21 = b.get1(2,1);
		double b22 = b.get1(2,2);
		
		double result = (a12 - a22) * (b21 + b22); 
		return result;
	}
}

