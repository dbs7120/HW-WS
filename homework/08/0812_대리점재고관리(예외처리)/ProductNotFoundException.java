package d0812.Product;

public class ProductNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super("상품이 존재하지 않습니다.");
	}

}
