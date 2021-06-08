package challenge_superchat.dk.exceptions;

@SuppressWarnings("serial")
public class ServiceClientException extends Exception {

    public ServiceClientException(String message) {
        super(message);
    }
}