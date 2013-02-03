import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

	
	public static void usage() {
		String msg = "Usage: java main [file1] [file2] [file3] " +					 
					 "where file contains Matrix(es) in the format: \n" +					 
					 "rows/cols\n" +
					 "[Matrix].\n" +
					 "with rows,cols representing number of row/col in Matrix";					 
		System.out.println(msg);
	}
	public static void main(String[] args) {
		
		if (args.length != 3) {
			usage();
			return;
		}
		
		for (int i = 0; i < 3; ++i) {
			File f = new File(args[i]);
			try {
				MatrixReader mr = new MatrixReader(f);
				ArrayList<Matrix> matrices = mr.getMatrix();
				Matrix m1 = matrices.get(0);
				Matrix m2 = matrices.get(1);
				
				MatrixPair mp = new MatrixPair(m1,m2);
				algCompare(Arrays.asList(mp));
				System.out.println("\n");
				
			} catch (FileNotFoundException e) {
				String err = "The following file was not found:\n" +
						      f.toString() + "\n"; 
				err += "Please give correct file paths and try again"; 
				System.out.println(err);
				System.exit(-1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				String err = "An error occured while parsing the" +
							 " Matrix file:\n" + f.getAbsolutePath() + "\n" +
							 e + "\n" +
							 "Please check the format of the file and try" +
							 "again";
				System.out.println(err);
			}
		}
		
	}
	
	public static void t1() {
		int size;
		for (int i = 0; i < 3; ++i) {
			size = (int) Math.pow(2, i+1);
			System.out.printf("Testing Matrix of %d\n", size);
			Matrix m1 = generateRandomMatrix(size,size);
			Matrix m2 = generateRandomMatrix(size,size);
			
			MatrixPair mp = new MatrixPair(m1, m2);
			algCompare(Arrays.asList(mp));
			System.out.println("\n");
		}
	}
	public static void t0() {
		double[][] t1 = {{1,4,6,8}, {7,5,9,6}, {7,9,2,1}, {8,3,2,6}};
		Matrix m1 = new Matrix(4,4);
		m1.set(t1);
		
		double[][] t2 = {{8,3,2,1}, {9,5,2,4}, {3,4,7,5}, {2,4,7,8}};
		Matrix m2 = new Matrix(4,4);
		m2.set(t2);
		
		MatrixPair mp = new MatrixPair(m1, m2);
		
		algCompare(Arrays.asList(mp));
	}
	
	/**
	 * Generate a Random Matrix
	 * @param row
	 * @param col
	 * @return
	 */
	public static Matrix generateRandomMatrix(int row, int col) {
		
		Matrix m = new Matrix(row,col);
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				try {
					m.set(i, j, f(Math.random()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return m;
	}
	
	private static double f(double n) {
		return Math.sin(n) * Math.cos(n);
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
				System.out.println("2-norm of Error Matrix is " + diff.norm());
				System.out.println("Avg size of an element is " + diff.norm());
				System.out.println("\n ----------- \n");
				
			} catch (Exception e) {
				System.out.println("Error Occured: " + e);
				continue;
			}
		}
	}
}
