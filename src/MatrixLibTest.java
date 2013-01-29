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
	}
}
