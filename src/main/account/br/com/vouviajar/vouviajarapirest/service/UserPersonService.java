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
import br.com.vouviajar.vouviajarapirest.repository.UserPersonRepository;

@Service
public class UserPersonService{
    
    private UserPersonRepository userRepository; 

    @Autowired
    public UserPersonService(UserPersonRepository userRepository){
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
        if(userRepository.findByEmail(user.getEmail()) != null)
        	throw new UserAlreadyRegisteredException();            
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
    	User userDB = verifyIfUserExists(id);    	
    	return updateUser(user, userDB);
    }
    
    private User updateUser(User user, User userDB) {
    	userDB.setEmail(user.getEmail());
    	userDB.setPassword(user.getPassword());
    	userDB.setModifiedOn(OffsetDateTime.now());
    	return userRepository.save(userDB);
    }
    
    public void delete(Long id) {    	
    	User user = verifyIfUserExists(id);
    	user.setActive(false);
    	userRepository.save(user);    	
    }
    
    private User verifyIfUserExists(Long id) {
    	Optional<User> userDB = userRepository.findById(id);;
    	if( userDB == null)
    		throw new NotFoundException("User not found"); 
    	return userDB.get();
    }
    
    private void validateData(User user) {
    	if(user.getEmail() == null || user.getPassword()==null 
    			|| user.getEmail() == "" || user.getPassword() == "")
    		throw new UninformedCredentialsException();
    }
}