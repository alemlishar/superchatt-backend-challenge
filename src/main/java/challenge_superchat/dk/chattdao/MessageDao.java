package challenge_superchat.dk.chattdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge_superchat.dk.chattmodel.Message;

@Repository
public interface MessageDao extends CrudRepository<Message, Long>{


}
