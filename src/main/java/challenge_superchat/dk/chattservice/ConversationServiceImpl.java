package challenge_superchat.dk.chattservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import challenge_superchat.dk.chattdao.ConversationDao;
import challenge_superchat.dk.chattdao.MessageDao;
import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;

@Service
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	private ConversationDao conversationDao;

	@Autowired
	private MessageDao messageDao;



	@Transactional
	public Boolean sendMessage(Message message) {
		// TODO Auto-generated method stub

		Conversations conversation = new Conversations();
		Message msg = new Message();
		conversation = countNumberOfConversation( message.getIdSender(), message.getIdReciepnt());
		if(conversation != null) {
		if((conversation.getIdReciepnt() == message.getIdReciepnt() && conversation.getIdSender() == message.getIdSender())
				||	
				(conversation.getIdReciepnt() == message.getIdReciepnt() && conversation.getIdSender() == message.getIdSender())) 
		     	msg= new Message(message.getMessageBody() , conversation, message.getIdSender(), message.getIdReciepnt());

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
	public List<Message> getUserConversation(long idc) {

		List<Message> messages = new ArrayList<Message>();
		messages = messageDao.searchUserConversations(idc);

		if(messages != null)
			return messages;
		else
			return messages;

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
	
	
	@Transactional
	public Conversations countNumberOfConversation(long senderId, long recieverId) {
		// TODO Auto-generated method stub

		Conversations conv = new Conversations();
		conv = conversationDao.checkIfConversationExist(senderId, recieverId);

		return conv;

	}

	
	@Override
	public Message convertPlaceholers(Message message) {
		return null;
	}

	@Override
	public boolean checkConversationExisted(Message message) {
		return false;
	}


}
