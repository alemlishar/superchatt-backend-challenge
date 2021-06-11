package challenge_superchat.dk.chattservice;

import java.util.List;

import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.chattmodel.User;

public interface ConversationService {
	
	public Boolean sendMessage(Message message);
	public Message convertPlaceholers(Message message);
	public boolean checkConversationExisted(Message message);
	public List<String> constructUserConversations(List<Message> messages);
	public List<String> getUserConversation(long idc);
}
