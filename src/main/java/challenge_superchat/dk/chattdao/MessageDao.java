package challenge_superchat.dk.chattdao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import challenge_superchat.dk.chattmodel.Message;

@Repository
public interface MessageDao extends CrudRepository<Message, Long>{

	

	@Query(value = "SELECT * FROM messages  WHERE idc = :idc", nativeQuery = true)
    List<Message> searchUserConversations(@Param("idc") Long idc );
}
