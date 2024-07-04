package ads.com.list;

public class NoDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoDataException(String errorMessage) {
		super(errorMessage);
	}
}
