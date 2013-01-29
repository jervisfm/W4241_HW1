
public class Matrix {

	private double[][] data;
	
	public Matrix(int rows, int cols) {
		this.data = new double[rows][cols];
	}
	
	public double get(int row, int col){
		return data[row][col];
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
		
}
