package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.exception.NotFoundException;
import br.com.vouviajar.vouviajarapirest.exception.UninformedCredentialsException;
import br.com.vouviajar.vouviajarapirest.exception.UserAlreadyRegisteredException;
import br.com.vouviajar.vouviajarapirest.model.User;
import br.com.vouviajar.vouviajarapirest.repository.UserRepository;

@Service
public class UserService{
    
    private UserRepository userRepository; 

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> getById(Long id) {	
    	return userRepository.findById(id);
    }

    public List<User> getAll() {    	
    	return userRepository.findAll();
    }
    
    public User register(User user){
    	validateData(user);    	  
        if(userRepository.findByEmail(user.getEmail()) != null) {
        	throw new UserAlreadyRegisteredException();
        }            
        return registerUser(user);
    }

    private User registerUser(User user) {    	
    	user.setActive(true);
    	user.setEnable(false);
    	user.setCreatedOn(OffsetDateTime.now());
    	user.setModifiedOn(OffsetDateTime.now());
    	user.setStaff(false);
    	return userRepository.save(user);
    }
    
    public User update(User user, Long id) {    	
    	validateData(user);    	  
    	User user_db = verifyIfUserExists(id);    	
    	return updateUser(user, user_db);
    }
    
    private User updateUser(User user, User user_db) {
    	user_db.setEmail(user.getEmail());
    	user_db.setPassword(user.getPassword());
    	user_db.setModifiedOn(OffsetDateTime.now());
    	return userRepository.save(user_db);
    }
    
    public void delete(Long id) {    	
    	User user = verifyIfUserExists(id);
    	user.setActive(false);
    	userRepository.save(user);    	
    }
    
    private User verifyIfUserExists(Long id) {
    	Optional<User> user_db = userRepository.findById(id);;
    	if( user_db == null) {
    		throw new NotFoundException("User not found"); 
    	}
    	return user_db.get();
    }
    
    private void validateData(User user) {
    	if(user.getEmail() == null || user.getPassword()==null 
    			|| user.getEmail() == "" || user.getPassword() == ""){
    		throw new UninformedCredentialsException();
    	}
    }
}
