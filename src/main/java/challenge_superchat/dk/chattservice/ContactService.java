package challenge_superchat.dk.chattservice;

import java.util.Collection;

import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.exceptions.ServiceClientException;
/**
 * 
 * @author Utente 1
 * @implNote user creation, listing contacts and getting user by email
 *
 */

public interface ContactService {

	    String CreateContact(User context) throws ServiceClientException;;
	    Collection<User> getContactList();
	    Collection<User> getUsersByEmail(String petName);

	
}
