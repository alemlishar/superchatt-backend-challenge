package challenge_superchat.dk.exceptions;



import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {

    private Date timestamp;
    private String message;
    private String error;
    
    public ApiError() {
	}
    
 
    public ApiError(Date timestamp, String message, String error) {
        super();
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
    }

	public Date timestamp() {
		return timestamp;
	}

	public void setStatus(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrors() {
		return error;
	}

	public void setErrors(String errors) {
		this.error = errors;
	}
    
    
}