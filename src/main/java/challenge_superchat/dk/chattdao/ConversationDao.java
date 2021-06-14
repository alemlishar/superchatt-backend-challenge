package challenge_superchat.dk.chattdao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge_superchat.dk.chattmodel.Conversations;

@Repository
public interface ConversationDao extends CrudRepository<Conversations, Long> {

	
	@Query(value = "SELECT * FROM conversations WHERE (recieverid = :recieverId AND senderid = :senderId) OR "
			        + "(recieverid = :senderId AND senderid = :recieverId)", nativeQuery = true)
	public Conversations checkIfConversationExist(long senderId, long recieverId);
}
	