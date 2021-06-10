package challenge_superchat.dk.chattservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import challenge_superchat.dk.chattdao.UserDao;
import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.exceptions.ServiceClientException;

@Service
public class ContactsServiceImpl implements ContactService
{
	@Autowired
	private UserDao userDao;
	
	
    public ContactsServiceImpl(UserDao userDao1) {
        this.userDao = userDao1;
    }

	@Override
	public String CreateContact(User context) throws ServiceClientException {
		// TODO Auto-generated method stub
		

		        if (context == null)
		            throw new ServiceClientException("The user sign up context cannot be null");

		        try {

		            User savedUser = userDao.save(context);

		            return savedUser.getEmail();

		        } catch (DuplicateKeyException e) {
		            throw new ServiceClientException("A user with the same username already exists");
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
            return null;

        Collection<User> returner = new ArrayList<>();
        users.forEach(x -> returner.add(new User(x)));

        return returner;
		
	}

	@Override
	public Collection<User> getUsersByEmail(String petName) {
		// TODO Auto-generated method stub
		
		 Collection<User> users = userDao.findByEmail(petName);

	        if (users == null || users.isEmpty())
	            return null;

	        return users.stream().map(User::new).collect(Collectors.toList());
	}

	
  
}
