package by.bsu.mmf.Lab4.PartB;

public class MusicException extends Exception{

    public MusicException() {
    }
    public MusicException(String message) {
        super(message);
    }
    public MusicException(String message, Throwable cause) {
        super(message, cause);
    }
    public MusicException(Throwable cause) {
        super(cause);
    }

}
