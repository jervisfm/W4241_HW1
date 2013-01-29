import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MatrixUtilTest {

	private double test[][];
	private Matrix mat; 
	
	@Before
	public void setUp() throws Exception {
		double temp[][] = { {1,2}, {3,4} };
		test = temp;
		mat = new Matrix(2,2);
		mat.set(test);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	
	@Test
	public void getSizes() {
		double temp[][] = { {1,2,3}, {4,5,6} };
		int expectedRowSize = 2;
		int expectedColSize = 3;
		Matrix m = new Matrix(expectedRowSize, expectedColSize); 
		
		m.set(temp);
		
		int actualRowSize = MatrixUtil.rowSize(m); 
		int actualColSize = MatrixUtil.colSize(m); 
		
		assertEquals(expectedRowSize, actualRowSize);
		assertEquals(expectedColSize, actualColSize); 
	}

	@Test
	public void canDotProduct() {
		Matrix m1 = new Matrix(1,5);
		Matrix m2 = new Matrix(1,5);
		
		assertTrue(MatrixUtil.canDotProduct(m1, m2));
		
		Matrix m3 = new Matrix (2,5);
		Matrix m4 = new Matrix (1,6); 
		assertFalse(MatrixUtil.canDotProduct(m1, m3));
		assertFalse(MatrixUtil.canDotProduct(m1, m4));
	}
	@Test
	public void dotProduct() {
		double t1[][] = {{1,2,3}};
		double t2[][] = {{7,4,5}};
		double expected = 30;
		Matrix m1 = new Matrix(1,3);
		m1.set(t1);
		
		Matrix m2 = new Matrix(1,3);
		m2.set(t2);
		
		try {
			double actual = MatrixUtil.dotProduct(m1, m2);
			assertEquals(expected, actual, Math.pow(10, -7));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Failed to compute dot product: " + e);
		}
	}
}
