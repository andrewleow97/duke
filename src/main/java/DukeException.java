/**
 * Customized Exception class for Duke
 */
public class DukeException extends Exception {
    public DukeException(String error) {
        super(error);
    }

    public static String toString(String error) {
        return error;
    }
}
