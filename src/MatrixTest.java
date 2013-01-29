import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void CreateMatrix() {
		double test[][] = { {1,2}, {3,4} };
		Matrix m = new Matrix(2,2);
		m.set(test); 
		double[][] actual = m.data(); 
		assertArrayEquals(test, actual);
	}
	
	
	@Test
	public void SetMatrix() {
		double test[][] = { {1,2}, {3,4} };
		Matrix m = new Matrix(2,2); 
		m.set(test);
		
		// set a value and check it.
		double expected = 767;
		double actual;
		try {
			m.set(1, 1, expected);
			actual = m.get(1, 1);
			assertEquals(expected, actual, Math.pow(10, -6));
		} catch (Exception e) {
			fail("Incorrect Out of Index error:" + e);
		}

		
		
	}

}
