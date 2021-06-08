package challenge_superchat.dk.chattcontroller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import challenge_superchat.dk.chattdao.ConversationDao;
import challenge_superchat.dk.chattdao.MessageDao;
import challenge_superchat.dk.chattdao.UserDao;
import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.chattservice.ContactsServiceImpl;
import challenge_superchat.dk.exceptions.ServiceClientException;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ChattRestController {

	
	@Autowired
	ContactsServiceImpl contactsServiceImpl;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	ConversationDao conversationDao;
	
	
	@PostMapping("/contacts")
    public  ResponseEntity<?> createContacts(@RequestBody User user) {
		String userId = "";
        try {
        	if (user == null)
                throw new ServiceClientException("The passed user is not valid for sign up");

             userId = contactsServiceImpl.CreateContact(user);

            if (userId == null)
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

		} catch (ServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.created(URI.create("http://127.0.0.1:8080/users/" + userId)).build();
    }

    @GetMapping("/contacts")
    public List<User> listContacts() {
    	List<User> userList = new ArrayList<>();
         userList.addAll(contactsServiceImpl.getContactList());
         return userList;
    }

	@PostMapping("/message")
    public  boolean sendMessage() {
        return true;
    }
	
	@PostMapping("/conversations")
    public  Set<Conversations> listConversations() {
        return null;
    }
}
