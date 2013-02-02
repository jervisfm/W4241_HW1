import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Parses and reads a matrix from a string or file. 
 * @author Jervis
 *
 */
public class MatrixReader {

	private Matrix matrix; 
	private File f;
	public MatrixReader(File f) throws FileNotFoundException, Exception {
		this.f = f;
		readMatrixFromFile(); 
	}

	public MatrixReader(String s) throws Exception {
		readMatrixFromString(s);
	}
	
	public Matrix getMatrix() {
		return matrix;
	}
	
	
	
	private Matrix readMatrixFromString(String ms) throws Exception {
		Scanner in = new Scanner(ms); 
		String[] matDim = in.nextLine().split("\\s+");
		if (matDim.length != 2)
			throw new Exception("Row/Column not specified correctly");
		
		int rows = Integer.parseInt(matDim[0]);
		int cols = Integer.parseInt(matDim[1]);
		
		if (rows < 0 || cols < 0) {
			throw new Exception("Invalids rows/cols given:" + rows + "," +cols);
		}
		
		// Read the data matrix
		double[][] result = new double[rows][cols]; 
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				double val = Double.parseDouble(in.next());
				result[i][j] = val;
			}
		}
		Matrix mat = new Matrix(rows,cols);
		mat.set(result);
		this.matrix = mat;
		return mat;
	}
	
	
	/**
	 * Matrix Format is : 
	 * Rows Cols
	 * [Matrix-Data]
	 * return null if the file is empty or another error occured.
	 * @throws FileNotFoundException if the file does not exist
	 */
	private Matrix readMatrixFromFile() throws FileNotFoundException,
											   Exception {
		String ms = readFileToString(); 
		
		if (ms.isEmpty())
			return null;
		
		return readMatrixFromString(ms);
	}
	
	
	
	private String readFileToString() throws FileNotFoundException {
		
		Scanner in = new Scanner(f); 
		StringBuffer sb = new StringBuffer(100);
		while (in.hasNextLine()) {
			sb.append(in.nextLine());
		}
		return sb.toString();
	}
}
