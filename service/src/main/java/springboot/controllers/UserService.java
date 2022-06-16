package springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entities.User;
import springboot.repositories.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//private List<User> users = new ArrayList<>();

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;

	}
	public User getUser(Integer id) {
		 return userRepository.getOne(id);
	}


	public void adduser(User users) {
		userRepository.save(users);
		
	}
	public void updateUser(Integer id, User users) {
		userRepository.save(users);   	
	}
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}
	public Optional<User> findById(Integer id) {
	return userRepository.findById(id);
	
	}

}
