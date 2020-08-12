package d0812.Product;

public class CodeNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CodeNotFoundException() {
		super("해당 제품코드가 없습니다.");
	}

}
