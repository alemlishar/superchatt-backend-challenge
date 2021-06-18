package challenge_superchat.dk.chattservice;

import java.util.List;

import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.Message;
import challenge_superchat.dk.exceptions.ContactNotFoundException;
/**
 * 
 * @author Alemayehu 
 * @service
 *
 */

public interface ConversationService {
	
	public Boolean sendMessage(Message message) throws ContactNotFoundException;
	public String convertPlaceholers(Message message);
	public List<String> constructUserConversations(List<Message> messages);
	public String[] getUserConversation(long idc)throws ContactNotFoundException;
	public Conversations countNumberOfConversation(long senderId, long recieverId);
	public Message bitCoinTodayExchangeRate(Message message);
}
