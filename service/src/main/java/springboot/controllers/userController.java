package springboot.controllers;
import springboot.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
	@Autowired
	private  UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable Integer id)
	{
		return userService.getUser(id);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser( @Valid @RequestBody User users )
	{
		userService.adduser(users);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateTopic(@RequestBody User users,@PathVariable Integer id) {
		//System.out.println(users.getDiscrption());
		if(users.getDiscrption().isEmpty())
		{
			Map<String, String> errors = new HashMap<>();
			errors.put("message", "Task description required");
			errors.put("status", "400");
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);	
		}
		System.out.println(userService.findById(id));
		if(userService.findById(id).isEmpty()) {
			
			Map<String, String> errors1 = new HashMap<>();
			errors1.put("message", "Cannot find task with given id");
			errors1.put("status", "404");
			return new ResponseEntity<>(errors1, HttpStatus.NOT_FOUND);	
			
		}
		userService.updateUser(id,users);
		return new ResponseEntity<>(" success ", HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteTopic(@PathVariable Integer id)
	{
		userService.deleteUser(id);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	Map<String, String> errors = new HashMap<>();

	ex.getBindingResult().getFieldErrors().forEach(error ->
	errors.put(error.getField(), error.getDefaultMessage()));

	return errors;
}
}