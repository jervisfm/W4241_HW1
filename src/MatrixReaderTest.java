import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixReaderTest {

	@Test
	public void ReadMatrix() {
//		String s = "3 3\n" +
//				   "1 2 3\n" +
//				   "4 5 6\n" +
//				   "7 8 9\n";
		String s = "2 2\n" +
				   "0.22233246964857212 0.36738135130486793\n" + 
				   "0.07327389799637435 0.441073327740256 ";
		s += "\n\n" + s + "\n\n";
		double [][] ans = {{1,2,3}, {4,5,6}, {7,8,9}};
		String bs = "4 4\n" +
				    "1 2 3\n" +
				    "4 5 6\n" +
				    "7 8 9\n";
		
		// System.out.println(s);
		
		try {
			MatrixReader mr = new MatrixReader(s);
			Matrix actual = mr.getMatrix().get(0);
			Matrix actual2 = mr.getMatrix().get(1);
			Matrix expected = new Matrix(3,3); 
			expected.set(ans);
			assertTrue(actual.equals(expected));
			assertTrue(actual2.equals(expected));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
