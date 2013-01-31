
/**
 * A pair of Matrices
 * @author Jervis
 *
 */
public class MatrixPair {

	private Matrix a;
	private Matrix b; 
	
	public MatrixPair() {
		this.a = null;
		this.b = null;
	}
	
	public MatrixPair(Matrix a, Matrix b) {
		this.a = a;
		this.b = b;
	}
	
	public void setA(Matrix m) {
		this.a = m;
	}
	
	public void setB(Matrix m) {
		this.b = m;
	}
	
	public Matrix a() {
		return a;
	}
	
	public Matrix b() {
		return b;
	}
	
}
