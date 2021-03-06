import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author Jervis
 *
 */
public class MatrixTest {

	@Test
	public void createMatrix() {
		double test[][] = { {1,2}, {3,4} };
		Matrix m = new Matrix(2,2);
		m.set(test); 
		double[][] actual = m.data(); 
		assertArrayEquals(test, actual);
	}
	
	@Test
	public void setMatrix() {
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

	@Test
	public void invalidInputs() {
		double test[][] = { {1,2}, {3,4} };
		Matrix m = new Matrix(2,2); 
		// Invalid Set 
		try {
			m.set(2,2,240);
			fail("Invalid Index Input not caught");
		} catch (Exception e) {
			// Success
		}
		
		// Invalid Get
		try {
			m.get(2,2);
			fail("Invalid Index Input not caught");
		} catch (Exception e) {
			// Success
		}
	}
	
	@Test
	public void getEntireRow() {
		double test[][] = { {1,2}, {3,4} };
		double exp [][] = {{1,2}};
		Matrix m = new Matrix(2,2);
		m.set(test);
		
		Matrix expected = new Matrix(1,2);
		expected.set(exp);
		
		Matrix actual =  m.getEntireRow(0);
		assertTrue(actual.compareTo(expected) == 0);
	}
	
	@Test
	public void getEntireCol() {
		double test[][] = { {1,2}, {3,4} };
		double exp [][] = {{1, 3}};
		Matrix m = new Matrix(2,2);
		m.set(test);
		
		Matrix expected = new Matrix(1,2);
		expected.set(exp);
		
		Matrix actual =  m.getEntireCol(0);
		assertTrue(actual.compareTo(expected) == 0);
	}
	
	@Test
	public void padZeros() {
		double test[][] = { {1,2}, {3,4} };
		double exp [][] = { {1,2,0}, {3,4,0}, {0,0,0} };
		Matrix m = new Matrix(2,2);
		m.set(test);
		
		Matrix expected = new Matrix(1,2);
		expected.set(exp);
		
		Matrix actual =  m.padZeros(1);
		assertTrue(actual.compareTo(expected) == 0);
	}
}
