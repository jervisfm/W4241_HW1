
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
		if (MatrixUtil.isOneByOne(a, b)) { /* Handle special case */
			Matrix result = new Matrix(1,1); 
			double val =  a.get(0, 0) * b.get(0, 0);
			result.set(0, 0, val);
			return result;
		} 
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
	
	private static Matrix Q1(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a11 = a.get1M(1, 1);
		Matrix a22 = a.get1M(2, 2);
		Matrix b11 = b.get1M(1, 1);
		Matrix b22 = b.get1M(2, 2);

		Matrix t1 = a11.add(a22); 
		Matrix t2 = b11.add(b22);
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}
	
	private static Matrix Q2(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a21 = a.get1M(2,1);
		Matrix a22 = a.get1M(2,2);
		Matrix b11 = b.get1M(1,1);
		
		Matrix t1 = a21.add(a22);
		Matrix t2 = b11; 
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}	
	
	private static Matrix Q3(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a11 = a.get1M(1,1);
		Matrix b12 = b.get1M(1,2); 
		Matrix b22 = b.get1M(2,2); 
		
		Matrix t1 = a11;
		Matrix t2 = b12.minus(b22);
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}	
	
	private static Matrix Q4(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a22 = a.get1M(2,2); 
		Matrix b11 = b.get1M(1,1); 
		Matrix b21 = b.get1M(2,1); 
		
		Matrix t1 = a22; 
		Matrix t2 = b21.minus(b11);
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}
	
	private static Matrix Q5(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a11 = a.get1M(1, 1);
		Matrix a12 = a.get1M(1,2);
		Matrix b22 = b.get1M(2,2); 
		
		Matrix t1 = a11.add(a12);
		Matrix t2 = b22;
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}
	
	private static Matrix Q6(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a11 = a.get1M(1,1);
		Matrix a21 = a.get1M(2,1);
		Matrix b11 = b.get1M(1,1);
		Matrix b12 = b.get1M(1,2);
		
		Matrix t1 = a21.minus(a11);
		Matrix t2 = b11.add(b12);
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}
	
	private static Matrix Q7(Matrix a, Matrix b) throws Exception {
		
		if (!MatrixUtil.isTwoByTwo(a, b))
			throw new Exception("Matrices should be 2x2");

		Matrix a12 = a.get1M(1,2);
		Matrix a22 = a.get1M(2,2);
		Matrix b21 = b.get1M(2,1);
		Matrix b22 = b.get1M(2,2);
		
		Matrix t1 = a12.minus(a22);
		Matrix t2 = b21.add(b22);
		Matrix result = strasMultHelper(t1, t2);
		return result;
	}
}

