package challenge_superchat.dk.chattservice;

import java.util.Collection;
import java.util.List;

import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.exceptions.ServiceClientException;

public interface ContactService {

	    String CreateContact(User context) throws ServiceClientException;;
	    Collection<User> getContactList();
	    Collection<User> getUsersByEmail(String petName);

	
}
