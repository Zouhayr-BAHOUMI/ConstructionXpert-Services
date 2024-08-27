package projetservice.exception;



public class ProjetNotFoundException extends RuntimeException{

    public ProjetNotFoundException() {
        super("projet not found !");
    }
}
