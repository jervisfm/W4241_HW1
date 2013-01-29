import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixLibTest {

	@Test
	public void mult() {
		double t1[][] = { {1,2}, {3,4} };
		Matrix m1 = new Matrix(2,2);
		m1.set(t1);
		
		double t2[][] = { {7,8}, {6,5} };
		Matrix m2 = new Matrix(2,2);
		m2.set(t2);
		
		double ans[][] = {{19, 18}, {45, 44}};
		Matrix expected = new Matrix(2,2);
		expected.set(ans);
		
		Matrix actual = MatrixLib.mult(m1, m2);
		assertTrue(expected.compareTo(actual) ==  0);
		
		// Test Non-Square Matrix Mult
		double t3[][] = { {7,8,3}, {6,5,7} };
		Matrix m3 = new Matrix(2,3);
		m3.set(t3);
		
		double ans2[][] = {{19, 18,17}, {45, 44, 37}};
		expected = new Matrix(2,3);
		expected.set(ans2);
		
		
		actual = MatrixLib.mult(m1, m3);
		assertTrue(expected.compareTo(actual) ==  0);
		
	}
	
	
}
