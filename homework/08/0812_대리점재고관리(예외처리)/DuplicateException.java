package d0812.Product;

public class DuplicateException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateException() {
		super("이미 존재하는 상품번호입니다");
	}

}
