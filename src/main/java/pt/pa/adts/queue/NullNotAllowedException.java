package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Null values are not allowed.");
    }

  public NullNotAllowedException(String message) {
    super(message);
  }
}
