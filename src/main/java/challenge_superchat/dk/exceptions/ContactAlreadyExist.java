package challenge_superchat.dk.exceptions;

@SuppressWarnings("serial")
public class ContactAlreadyExist extends RuntimeException {
	
	private String message;

    public ContactAlreadyExist(String message) {
        super(message);
        this.message = message;
    }

    public ContactAlreadyExist() {
    }
}
