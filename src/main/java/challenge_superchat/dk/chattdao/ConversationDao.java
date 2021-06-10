package challenge_superchat.dk.chattdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge_superchat.dk.chattmodel.Conversations;

@Repository
public interface ConversationDao extends CrudRepository<Conversations, Long> {

}
