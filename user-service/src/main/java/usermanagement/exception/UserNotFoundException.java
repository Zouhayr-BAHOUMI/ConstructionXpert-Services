package usermanagement.exception;

public class UserNotFoundException extends RuntimeException{

    UserNotFoundException(){
        super("User not found !");
    }
}
