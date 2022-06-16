package springboot.test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.entities.User;
import springboot.repositories.UserRepository;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
	@Autowired
	UserRepository userrepo;
	@Test
	@Order(1)
	public void testCreate()
	{
		User u=new User();
		u.setId(1);
		u.setFirstname("manvith");
		u.setLastname("Reddy");
		u.setEmail("manvith@gmail.com");
		u.setMobile("8096897242");
		userrepo.save(u);
		assertNotNull(userrepo.findById(1).get());
	}
	@Test
	@Order(2)
	public void testReadAll()
	{
		List<User> list=userrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testSingleUser()
	{
		User user=userrepo.findById(1).get();
		assertEquals("manvith", user.getFirstname());
	}
	@Test
	@Order(4)
	public void testUpdate()
	{
		User u=userrepo.findById(1).get();
		u.setMobile("8096897243");
		userrepo.save(u);
		assertNotEquals("8096897242",userrepo.findById(1).get().getMobile());
		
	}
	@Test
	@Order(5)
	public void testDelete()
	{
		userrepo.deleteById(1);
		assertThat(userrepo.existsById(1)).isFalse();
	}

}

