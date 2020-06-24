package br.com.vouviajar.vouviajarapirest.service;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.dto.UserCredentialsDTO;
import br.com.vouviajar.vouviajarapirest.exception.PasswordInvalidException;
import br.com.vouviajar.vouviajarapirest.exception.UninformedCredentialsException;
import br.com.vouviajar.vouviajarapirest.exception.UserAlreadyRegisteredException;
import br.com.vouviajar.vouviajarapirest.exception.EmailInvalidException;
import br.com.vouviajar.vouviajarapirest.models.User;
import br.com.vouviajar.vouviajarapirest.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository; 

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(User user){

    	if(user.equals(null) || user.isEmpty()){
    		throw new UninformedCredentialsException();
    	}
    	
        if(userRepository.findByEmail(user.getEmail()) == null) {
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
    
}
