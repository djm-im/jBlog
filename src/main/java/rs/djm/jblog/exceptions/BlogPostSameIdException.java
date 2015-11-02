package rs.djm.jblog.exceptions;

public class BlogPostSameIdException extends Exception {

    public BlogPostSameIdException(String errorMessage) {
        super(errorMessage);
    }

    public BlogPostSameIdException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

}
