
public class Matrix {

	private double[][] data;
	
	public Matrix(int rows, int cols) {
		this.data = new double[rows][cols];
	}
			
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
		return super.toString();
	}
	/**
	 * Checks if the given indice values are valid
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
}
