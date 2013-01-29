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

	
	
}
