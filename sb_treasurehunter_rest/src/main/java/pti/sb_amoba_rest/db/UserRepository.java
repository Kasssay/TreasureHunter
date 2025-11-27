package pti.sb_amoba_rest.db;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pti.sb_amoba_rest.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

	@Query("SELECT * FROM user WHERE name =:userName AND password =:userPassword")
	public Optional<User> getUserByNameAndPassword(
			@Param("userPassword") String password,
			@Param("userName") String name);
			
}
