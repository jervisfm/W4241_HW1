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
			fail("Failed to do multiplication");
		}
		
		
		
	}

}
