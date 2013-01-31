import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		
		
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
