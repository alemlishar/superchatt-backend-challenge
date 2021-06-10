package challenge_superchat.dk.exceptions;

public class ResourceAlreadyExist extends RuntimeException {
	
	private String message;

    public ResourceAlreadyExist(String message) {
        super(message);
        this.message = message;
    }

    public ResourceAlreadyExist() {
    }
}
