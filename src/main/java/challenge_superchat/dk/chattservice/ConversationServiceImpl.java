package challenge_superchat.dk.chattservice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import challenge_superchat.dk.chattdao.ConversationDao;
import challenge_superchat.dk.chattdao.MessageDao;
import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;

/**
 * 
 * @author Alemayehu 
 * @implNote Conversation service implementation(listing contact conversation, send message)
 *
 */

@Service
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	private ConversationDao conversationDao;

	@Autowired
	private MessageDao messageDao;



	@Transactional
	public Boolean sendMessage(Message message) {
		// TODO Auto-generated method stub
		String msgPlaceholder = ""; 
		msgPlaceholder = convertPlaceholers(message);

		Conversations conversation = new Conversations();
		Message msg = new Message();
		conversation = countNumberOfConversation( message.getIdSender(), message.getIdReciepnt());
		if(conversation != null) {
			if((conversation.getIdReciepnt() == message.getIdReciepnt() && conversation.getIdSender() == message.getIdSender())
					||	
					(conversation.getIdReciepnt() == message.getIdReciepnt() && conversation.getIdSender() == message.getIdSender())) 

				msg= new Message(msgPlaceholder , conversation, message.getIdSender(), message.getIdReciepnt());

		}else {
			conversation = new Conversations(message.getIdSender(), message.getIdReciepnt());
			Conversations conv = conversationDao.save(conversation);
			msg= new Message(message.getMessageBody(), conv, message.getIdSender(), message.getIdReciepnt());
		}

		if(messageDao.save(msg) != null)
			return true;
		else
			return false;

	}


	@Transactional
	public String[] getUserConversation(long idc) {

		List<Message> messages = new ArrayList<Message>();
		messages = messageDao.searchUserConversations(idc);
		String [] userConversations = messages.toArray(new String[] {});
		if(userConversations.length > 0)
			return userConversations;
		else {
			userConversations[0]="You Dont have any Conversations yet,"
					+ " please Send Message to Start your first Conversation";
			return userConversations;

		}

	}


	@Transactional
	public Conversations countNumberOfConversation(long senderId, long recieverId) {

		Conversations conv = new Conversations();
		conv = conversationDao.checkIfConversationExist(senderId, recieverId);

		return conv;

	}


	@Override
	public String convertPlaceholers(Message message) {
		
		String word = message.getMessageBody();	
		String wordsToReplace = String.valueOf(message.getIdReciepnt());
		
		
		String convertedPlaceholder = word.replace("$name", wordsToReplace);
        System.out.println("message:" + message.getMessageBody() + "recieverId:" + wordsToReplace);
	
        System.out.println("final converted: " + convertedPlaceholder);

		return convertedPlaceholder; //We return the modified word
	}



	@Override
	public Message bitCoinTodayExchangeRate(Message message) {


		return null;
	}


	@SuppressWarnings("null")
	@Override
	public List<String> constructUserConversations(List<Message> messages) {
		List<String> conversationList = null;

		for (Message msg : messages) {
			conversationList.add(msg.getMessageBody());

		}


		return conversationList;
	}


}
