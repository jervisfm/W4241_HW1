import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Parses and reads a matrix from a string or file. 
 * @author Jervis
 *
 */
public class MatrixReader {

	private ArrayList<Matrix> matrix; 
	private File f;
	public MatrixReader(File f) throws FileNotFoundException, Exception {
		this.f = f;
		matrix = new ArrayList<Matrix>();
		readMatrixFromFile(); 
	}

	public MatrixReader(String s) throws Exception {
		matrix = new ArrayList<Matrix>();
		readMatrixFromString(s);
	}
	
	public ArrayList<Matrix> getMatrix() {
		return matrix;
	}
	
	private void readMatrixFromString(String ms) throws Exception {
		Scanner in = new Scanner(ms);
		in.useDelimiter("\\s+"); // Skip over all whitespace chars
		
		// Read the data matrix
		do {
			String[] matDim = new String[2];
			matDim[0] = in.next(); 
			matDim[1] = in.next();
			if (matDim.length != 2)
				throw new Exception("Row/Column not specified correctly");
			
			int rows = Integer.parseInt(matDim[0]);
			int cols = Integer.parseInt(matDim[1]);
			
			if (rows < 0 || cols < 0) {
				throw new Exception("Invalids rows/cols given:" +
									rows + "," +cols);
			}
			
			double[][] result = new double[rows][cols]; 
			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < cols; ++j) {
					double val = Double.parseDouble(in.next());
					result[i][j] = val;
				}
			}
			Matrix mat = new Matrix(rows,cols);
			mat.set(result);
			this.matrix.add(mat);
		} while (in.hasNext());
		
	}
	
	
	/**
	 * Matrix Format is : 
	 * Rows Cols
	 * [Matrix-Data]
	 * return null if the file is empty or another error occured.
	 * @throws FileNotFoundException if the file does not exist
	 */
	private void readMatrixFromFile() throws FileNotFoundException,
											   Exception {
		String ms = readFileToString(); 
		
		if (ms.isEmpty())
			throw new Exception("Empty Matrix string given");
		
		readMatrixFromString(ms);
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
