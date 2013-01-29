
public class MatrixUtil {

	public static int rowSize(Matrix m) {
		return m.data().length; 
	}
	
	public static int colSize(Matrix m) {
		return m.data()[0].length;
	}
	
	public static boolean canMultiply(Matrix a, Matrix b) {
		return a.colSize() == b.rowSize(); 
	}
	
	
	public static boolean isSameSize(Matrix a, Matrix b) {
		return  a.rowSize() == b.rowSize() &&
			    a.colSize() == b.colSize();
	}

}
