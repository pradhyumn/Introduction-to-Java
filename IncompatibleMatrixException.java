package complexmatrix;

public class IncompatibleMatrixException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IncompatibleMatrixException() {}

	public IncompatibleMatrixException(String errorMsg) {
		super(errorMsg);
	}
	
}
