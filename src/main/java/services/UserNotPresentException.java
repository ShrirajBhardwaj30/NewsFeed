package services;

public class UserNotPresentException extends Exception {
    public UserNotPresentException(String e) {
        super(e);
    }
}
