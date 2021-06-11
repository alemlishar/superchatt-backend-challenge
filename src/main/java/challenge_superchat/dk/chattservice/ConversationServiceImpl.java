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
	   conversation.setIdReciepnt(message.getIdReciepnt());
	   conversation.setIdSender(message.getIdSender());

	   Conversations conv = conversationDao.save(conversation);
		System.out.println("conversation id in conv " + conv.getIdc());
		Message msg = new Message(message.getMessageBody(), conv, message.getIdSender(), message.getIdReciepnt());
	   
		   if(messageDao.save(msg) != null)
			   return true;
		   else
			   return false;

	}

	

		
		@Transactional
		public List<String> getUserConversation(long idc) {
			String emptyConv = "You have no Conversation so far";
			
			List<Message> messages = messageDao.searchUserConversations(idc);
			List<String> adjustedConversation = new ArrayList<String>() ;
			adjustedConversation = constructUserConversations(messages);
			if(adjustedConversation != null)
				return adjustedConversation;
			else
				adjustedConversation.add(emptyConv);
				return adjustedConversation;
			
		}
		
		@Override
		public Message convertPlaceholers(Message message) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean checkConversationExisted(Message message) {
			// TODO Auto-generated method stub
			return false;
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
