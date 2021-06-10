package challenge_superchat.dk.chattservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import challenge_superchat.dk.chattdao.ConversationDao;
import challenge_superchat.dk.chattdao.MessageDao;
import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.chattmodel.User;

@Service
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	private ConversationDao conversationDao;
	
	@Autowired
	private MessageDao messageDao;
	
	

	@Transactional
	public List<String> getUserConversation(User user) {
		// TODO Auto-generated method stub
		
		//messageDao.fin
		return null;
	}

	@Transactional
	public Boolean sendMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println(message.getIdReciepnt() + message.getMessageBody() + message.getIdSender());
	   
	   Conversations conversation = new Conversations();
	   conversation.setIdReciepnt(message.getIdReciepnt());
	   conversation.setIdSender(message.getIdSender());

	   Conversations conv = conversationDao.save(conversation);
	   Message msg = new Message();
	   msg.setIdReciepnt(message.getIdReciepnt());
	   msg.setIdSender(message.getIdSender());
	   msg.setMessageBody(message.getMessageBody());
	  //       msg.setId(message.getIdSender() + message.getIdReciepnt());
	   //	   if(conv.getId() != 0) {
	   //	   msg.getConversations().setId(conv.getId());	   
		msg  = messageDao.save(message);
	   //		}
	   
		return msg.getId() !=0;
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

}
