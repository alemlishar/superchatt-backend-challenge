package challenge_superchat.dk.chattcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.chattmodel.User;
import challenge_superchat.dk.chattservice.ContactsServiceImpl;
import challenge_superchat.dk.chattservice.ConversationServiceImpl;

import challenge_superchat.dk.exceptions.ServiceClientException;

@RestController
@RequestMapping("/api/v1")
public class ChattRestController {

	
	@Autowired
	ContactsServiceImpl contactsServiceImpl;
	
	@Autowired
	ConversationServiceImpl conversationServiceImpl;
	
	
	
	
	@PostMapping("/contacts")
    public  String createContacts(@Valid @RequestBody User user) {
		String userId = "";
		System.out.println(user);
        try {
        	if (user != null)

             userId = contactsServiceImpl.CreateContact(user);
            return "User Created" + user.getName();

		} catch (ServiceClientException e) {
			e.printStackTrace();
		}
        return "User not Created";
    }

	
	
    @GetMapping("/contacts")
    public List<User> listContacts() {
    	 
    	List<User> userList = new ArrayList<>();
        userList.addAll(contactsServiceImpl.getContactList());
         
    	 return userList;
    }

	
    
    @PostMapping("/message")
    public  String sendMessage(@Valid @RequestBody Message message) {
		
		 if(conversationServiceImpl.sendMessage(message) == true)
			 return "Message Sent Successfuly";
		 else 
			 return "Message not Sent Successfuly";

    }
	
	
   
    @GetMapping("/conversations/{id}")
    @ResponseBody
    public  List<String> listConversations(@Valid @PathVariable("idc")  Long userId) {
		List<String> userConversations = conversationServiceImpl.getUserConversation(userId);
		if(userConversations.isEmpty())
			userConversations.add("You Dont have Conversations Before");
		
        return userConversations;
    }

}
