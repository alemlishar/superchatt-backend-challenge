package challenge_superchat.dk.chattservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import challenge_superchat.dk.chattdao.UserDao;
import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.exceptions.ContactAlreadyExist;
import challenge_superchat.dk.exceptions.ContactNotFoundException;
/**
 * 
 * @author Alemayehu 1
 * @implNote Contact Service implmentation(creating contact, listing all contacts)
 *
 */

@Service
public class ContactsServiceImpl implements ContactService
{
	@Autowired
	private UserDao userDao;


	public ContactsServiceImpl(UserDao userDao1) {
		this.userDao = userDao1;
	}

	@Override
	public String CreateContact(User context) throws ContactAlreadyExist, ContactNotFoundException {

		if (context == null)
			throw new ContactNotFoundException("Invalid Data, Contact not created!!");

		try {

			User savedUser = userDao.save(context);

			return savedUser.getEmail();

		} catch (DuplicateKeyException e) {
			throw new ContactAlreadyExist("A user with this Contact deatil already exists");
		}   
		catch (Exception e) {
			return null;
		}
	}


	@Override
	public Collection<User> getContactList() {
		// TODO Auto-generated method stub

		Iterable<User> users = userDao.findAll();

		if (!users.iterator().hasNext())
			throw new ContactNotFoundException("No Contacts Existed!!");

		Collection<User> returner = new ArrayList<>();
		users.forEach(x -> returner.add(new User(x)));

		return returner;

	}

	@Override
	public Collection<User> getUsersByEmail(String petName) {
		// TODO Auto-generated method stub

		Collection<User> users = new ArrayList<User>();
		users = userDao.findByEmail(petName);

		if (users == null || users.isEmpty()) {
			throw new ContactNotFoundException("Email not Existed!!");

		}
		return users.stream().map(User::new).collect(Collectors.toList());
	}



}
