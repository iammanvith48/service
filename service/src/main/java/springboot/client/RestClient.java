		package springboot.client;



import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class RestClient {
	
	private static final String GET_ALL_USERS="http://localhost:8093/users";
	private static final String GET_USER_BY_ID="http://localhost:8093/users/{id}";
	private static final String CREATE_USERS="http://localhost:8093/users";
	private static final String UPDATE_USERS="http://localhost:8093/users/{id}";
	private static final String DELETE_USERS="http://localhost:8093/users/{id}";
	static RestTemplate restTemplate=new RestTemplate();
	public static void main(String args[])
	{
	     callGetUsersAPI();
		
	}
	private static void callGetUsersAPI()
	{
		HttpHeaders headers=new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<String> entity=new HttpEntity<>("parameters",headers);
	ResponseEntity<String> result=restTemplate.exchange( GET_ALL_USERS, HttpMethod.GET, entity,String.class);
	System.out.println(result);
	}

}
