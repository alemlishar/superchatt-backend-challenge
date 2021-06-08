package challenge_superchat.dk.chattservice;

import java.util.List;

import challenge_superchat.dk.chattmodel.Conversations;
import challenge_superchat.dk.chattmodel.User;

public interface MessageService {
	
	public Boolean sendMessage();
	public List<Conversations> getUserConversation(User user);
}
