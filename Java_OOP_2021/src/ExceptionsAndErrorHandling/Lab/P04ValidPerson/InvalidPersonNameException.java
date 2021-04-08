package ExceptionsAndErrorHandling.Lab.P04ValidPerson;

public class InvalidPersonNameException extends Exception{
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
