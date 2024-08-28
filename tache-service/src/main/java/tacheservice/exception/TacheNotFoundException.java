package tacheservice.exception;

public class TacheNotFoundException extends RuntimeException {

    public TacheNotFoundException() {
        super("tache not found !");
    }
}
