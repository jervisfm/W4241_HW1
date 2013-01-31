import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		double[][] t1 = {{1,4,6,8}, {7,5,9,6}, {7,9,2,1}, {8,3,2,6}};
		Matrix m1 = new Matrix(4,4);
		m1.set(t1);
		
		double[][] t2 = {{8,3,2,1}, {9,5,2,4}, {3,4,7,5}, {2,4,7,8}};
		Matrix m2 = new Matrix(4,4);
		m2.set(t2);
		
		MatrixPair mp = new MatrixPair(m1, m2);
		
		algCompare(Arrays.asList(mp));
		
	}
	
	public static void algCompare(List<MatrixPair> pairs) {
		
		for (MatrixPair mp : pairs) {
			
			Matrix a = mp.a();
			Matrix b = mp.b();
			
			System.out.println("Matrix A: \n" + a);
			System.out.println("Matrix B: \n" + b);
			
			try {
				Matrix resultStras = StrassenUtil.multiply(a, b);
				Matrix resultNorm = MatrixLib.mult(a, b);
				
				System.out.println("Matrix AxB(Classical):\n" + resultNorm);
				System.out.println("Matrix AxB(Strassen): \n" + resultStras);
				
				Matrix diff = resultNorm.minus(resultStras);
				
				System.out.println("Error Matrix: \n" + diff);
				System.out.println("\n ----------- \n");
				
			} catch (Exception e) {
				System.out.println("Error Occured: " + e);
				continue;
			}
		}
	}
}
