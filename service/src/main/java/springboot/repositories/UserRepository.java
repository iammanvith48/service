
package springboot.repositories;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public void  save(UserRepository userRepository);
	//public List<Course> findByTopicId(String topicId);
	

}
