package ads.com.resizableStack;

public class StackOverflowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StackOverflowException(String errorMessage) {
		super(errorMessage);
	}
}
