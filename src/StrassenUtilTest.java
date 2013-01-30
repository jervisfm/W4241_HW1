import static org.junit.Assert.*;

import org.junit.Test;


public class StrassenUtilTest {

	@Test
	public void multiply2x2() {
		
		double[][] t1 = {{23,58}, {71,45}};
		Matrix m1 = new Matrix(2,2);
		m1.set(t1);
		
		double[][] t2 = {{38,13}, {64,83}};
		Matrix m2 = new Matrix(2,2);
		m2.set(t2);
		
		double[][] ans = {{4586, 5113}, {5578, 4658}};
		Matrix expected  = new Matrix(2,2); 
		expected.set(ans);
		
		try {
			Matrix actual = StrassenUtil.mult2x2(m1, m2);
			assertTrue(expected.equals(actual));
		} catch (Exception e) {
			fail("Failed to do multiplication:" + e);
		}
	}

	@Test
	public void multiply() {
		
		double[][] t1 = {{1,4,6,8}, {7,5,9,6}, {7,9,2,1}, {8,3,2,6}};
		Matrix m1 = new Matrix(4,4);
		m1.set(t1);
		
		double[][] t2 = {{8,3,2,1}, {9,5,2,4}, {3,4,7,5}, {2,4,7,8}};
		Matrix m2 = new Matrix(4,4);
		m2.set(t2);
		
		double[][] ans = {{78,79,108,111}, {140,106,129,120}, 
						 {145,78,53,61}, {109,71,78,78}};
		Matrix expected  = new Matrix(4,4); 
		expected.set(ans);
		
		try {
			Matrix actual = StrassenUtil.multiply(m1, m2);
			assertTrue(expected.equals(actual));
		} catch (Exception e) {
			fail("Failed to do multiplication:" + e);
		}
	}
}
