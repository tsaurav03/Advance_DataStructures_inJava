package ads.com.resizableQueue;

public class QueueOverflowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QueueOverflowException(String errorMessage) {
		super(errorMessage);
	}
}
