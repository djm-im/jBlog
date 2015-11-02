package rs.djm.jblog.exceptions;

public class BlogPostNotExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public BlogPostNotExistException(String errorMessage) {
		super(errorMessage);
	}

	public BlogPostNotExistException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
