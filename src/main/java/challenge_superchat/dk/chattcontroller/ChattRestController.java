package challenge_superchat.dk.chattcontroller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import challenge_superchat.dk.chattdao.ConversationDao;
import challenge_superchat.dk.chattdao.MessageDao;
import challenge_superchat.dk.chattdao.UserDao;
import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.chattmodel.User;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ChattRestController {

	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	ConversationDao conversationDao;
	
	
	@PostMapping("/contacts")
    public  Set<User> createContacts() {
        return null;
    }

    @GetMapping("/contacts")
    public List listContacts(Message message) {
        return null;
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
