package challenge_superchat.dk.chattservice;

import java.util.Collection;

import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.exceptions.ContactAlreadyExist;
import challenge_superchat.dk.exceptions.ContactNotFoundException;
/**
 * 
 * @author Alemayehu 1
 * @implNote user creation, listing contacts and getting user by email
 *
 */

public interface ContactService {

	    String CreateContact(User context) throws ContactAlreadyExist, ContactNotFoundException;
	    Collection<User> getContactList() throws ContactNotFoundException;
	    Collection<User> getUsersByEmail(String petName);

	
}
