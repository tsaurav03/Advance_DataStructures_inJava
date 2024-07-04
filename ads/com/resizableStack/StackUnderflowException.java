package ads.com.resizableStack;

public class StackUnderflowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StackUnderflowException(String errorMessage) {
		super(errorMessage);
	}
}
