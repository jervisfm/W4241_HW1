/**
 * 
 * @author Jervis Muindi
 *
 */
public class Matrix implements Comparable<Matrix>{

	private double[][] data;
	
	public Matrix(int rows, int cols) {
		this.data = new double[rows][cols];
	}

	/**
	 * Retrieves the element at the given position assuming 
	 * position is given in 1-based indexes. 
	 * @param row - row
	 * @param col - column
	 * @throws Exception - if invalid/non-existent index given.
	 */
	public double get1(int row, int col) throws Exception {
		checkOneBasedIndexRange(row, col);
		
		return data[row - 1][col - 1];
	}
	
	public Matrix getM(int row, int col) throws Exception {	
		return MatrixUtil.getMat(this, row, col);
	}
	
	/***
	 * Retrieves the matrix element at the given position using
	 * a 0-based index
	 * @param row - the row
	 * @param col - the col
	 * @return the found element
	 * @throws Exception if indices given invalid or out of range
	 */
	public double get(int row, int col) throws Exception{		
		
		checkIndexRange(row, col);
			
		return data[row][col];
	}

	
	public void set(double[][] data) {
		this.data = data; 
	}
	
	public double set(int row, int col, double value) throws Exception {
		checkIndexRange(row, col);
		return data[row][col] = value;
	}
	
	public int rowSize() {
		return data.length;
	}

	public int colSize() {
		return data[0].length;
	}
	
	public double[][] data() {
		return data;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		int rows = rowSize(); 
		int cols = colSize(); 
		
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {				
				sb.append(data[i][j] + ", ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Checks if the given indices values (0-based) are valid
	 * @param row - row
	 * @param col - column
	 * @return - true on success 
	 * @throws Exception an exception if range is invalid
	 */
	private boolean checkIndexRange(int row, int col) throws Exception {
		int rowSize = rowSize(); 
		int colSize = colSize(); 
		
		if (row >= rowSize || col >= colSize ||
			row  < 0       || col < 0)  {
			throw new Exception(String.format("Index Out of Range (%d,%d)",
								row, col));
		} else {
			return true;
		}
	}
	
	private boolean checkOneBasedIndexRange(int row, int col) throws Exception {
		int rowSize = rowSize(); 
		int colSize = colSize(); 
		
		if (row > rowSize || col > colSize ||
			row  < 1      || col < 1)  {
			throw new Exception(String.format("Index Out of Range (%d,%d)",
								row, col));
		} else {
			return true;
		}
	}
	
	public Matrix getEntireRow(int row) {
		
		int rowSize = rowSize();
		int colSize = colSize();
		
		if (row < 0 || row >= rowSize)
			return null;
		
		Matrix m = new Matrix(1,colSize); 
		for (int i = 0; i < colSize; ++i) {
			double val = data[row][i];
			try {
				m.set(0, i, val);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return m;
	}
	
	public Matrix getEntireCol(int col) {
		int rowSize = rowSize(); 
		int colSize = colSize(); 
		
		if (col < 0 || col > colSize)
			return null;
		
		Matrix m = new Matrix(1,rowSize);
		for (int i = 0; i < rowSize; ++i) {
			double val = data[i][col];
			try {
				m.set(0, i, val);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return m;
	}

	public Matrix add(Matrix other) throws Exception {
		
		if (!MatrixUtil.isSameSize(this, other))
			throw new Exception("Matrix addition only defined for " +
								"matrices of same size");
		
		int rows = rowSize();
		int cols = colSize(); 
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				data[i][j] += other.get(i, j);
			}
		}
		return this;
	}
	
	public Matrix minus(Matrix other) throws Exception {
		
		if (!MatrixUtil.isSameSize(this, other))
			throw new Exception("Matrix subtraction only defined for " +
								"matrices of same size");
		
		int rows = rowSize();
		int cols = colSize(); 
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				data[i][j] -= other.get(i, j);
			}
		}
		
		return this;
	}
	
	
	/**
	 * Determines if this matrix and the given matrix are equal
	 * @param o - ohter matrix to compare against.
	 * @return true if equal, false otherwise
	 */
	public boolean equals(Matrix o) {
		return this.compareTo(o) == 0;
	}
	
	@Override
	public int compareTo(Matrix o) {
		
		if (!MatrixUtil.isSameSize(this, o))
			return -1;
		
		int size = rowSize();
		double err = Math.pow(10, -9);
		for (int i = 0; i < size; ++i){
			for (int j = 0; j < size; ++j) {
				try {
					if (Math.abs(data[i][j] - o.get(i, j)) > err)
						return -1;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
