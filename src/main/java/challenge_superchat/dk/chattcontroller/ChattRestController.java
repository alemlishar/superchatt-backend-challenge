package challenge_superchat.dk.chattcontroller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.chattmodel.User;


@RestController
public class ChattRestController {

	
	@PostMapping("/contacts")
    public  Set<User> createContacts() {
        return null;
    }

    @GetMapping("/contacts")
    public boolean listContacts(Message message) {
        return true;
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
