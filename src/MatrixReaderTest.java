import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixReaderTest {

	@Test
	public void ReadMatrix() {
		
		String s = "3 3\n" +
				   "1 2 3\n" +
				   "4 5 6\n" +
				   "7 8 9\n";
		
		double [][] ans = {{1,2,3}, {4,5,6}, {7,8,9}};
		String bs = "4 4\n" +
				    "1 2 3\n" +
				    "4 5 6\n" +
				    "7 8 9\n";
		
		try {
			MatrixReader mr = new MatrixReader(s);
			Matrix actual = mr.getMatrix();
			Matrix expected = new Matrix(3,3); 
			expected.set(ans);
			assertTrue(actual.equals(expected));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Error occured: " + e);
			
		}
		
		try {
			// should fail
			MatrixReader mr2 = new MatrixReader(bs);
			fail("Invalid input did not throw an error: " + bs); 
		} catch(Exception e) {
			// success
		}
		
		
	}

}
