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

/**
 * 
 * @author Alemayehu
 * @apiNote Superchatt chatt Controller
 * ( 	*create contact,
 * 		*Get All contacts,
 * 		*Send Message to Reciever,
 * 		*List specific User Conversations) 
 * @version 0.1
 *
 */
@RestController
@RequestMapping("/api/v1")
public class ChattRestController {


	@Autowired
	ContactsServiceImpl contactsServiceImpl;

	@Autowired
	ConversationServiceImpl conversationServiceImpl;

	/**
	 * 	
	 * @param user, User profile(Nmae, email)
	 * @return String, User creation with the id to use for sending message
	 */


	@PostMapping("/contacts")
	public  String createContacts(@Valid @RequestBody User user) {
		@SuppressWarnings("unused")
		String userId;
		System.out.println(user);
		if (user != null)
		{
			userId = contactsServiceImpl.CreateContact(user);
			return user.getName() + "Username: " +  userId + "created" ;
		}
		return "User Existed with this user profile, try with another Email or Name";
	}

	/**
	 * 	
	 * @param empty
	 * @return User Lists
	 * 
	 */	

	@GetMapping("/contacts")
	public List<User> listContacts() {

		List<User> userList = new ArrayList<>();
		userList.addAll(contactsServiceImpl.getContactList());

		return userList;
	}

	/**
	 * 
	 * @param message  has id sender, id reciever, messagebody(can have placeholders)
	 * @return String, notify successfull or un successful message delivery
	 */


	@PostMapping("/message")
	public  String sendMessage(@Valid @RequestBody Message message) {

		if(conversationServiceImpl.sendMessage(message) == true)
			return "Message Sent Successfuly";
		else 
			return "Message not Sent Successfuly";

	}

	/**
	 * 
	 * @param idc, user id to be retrived during message creation
	 * @return  List of conversations the user had done since registration
	 */
	@GetMapping("/conversations/{idc}")
	@ResponseBody
	public  String[] listConversations(@Valid @PathVariable("idc")  Long idc) {
		var  userConversations = conversationServiceImpl.getUserConversation(idc);

		return userConversations;
	}

}
