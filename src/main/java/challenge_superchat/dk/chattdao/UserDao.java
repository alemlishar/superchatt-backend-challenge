package challenge_superchat.dk.chattdao;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge_superchat.dk.chattmodel.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{


    Collection<User> findByEmail(String petName);
}
