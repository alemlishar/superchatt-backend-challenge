package challenge_superchat.dk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactNotFoundException() {
	        super();
	    }

	    public ContactNotFoundException(String message) {
	        super(message);
	    }

	    public ContactNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
