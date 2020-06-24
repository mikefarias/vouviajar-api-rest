package br.com.vouviajar.vouviajarapirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajarapirest.dto.UserCredentialsDTO;
import br.com.vouviajar.vouviajarapirest.exception.PasswordInvalidException;
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
    	return userRepository.save(user);
    }

    public Optional<User> getUser(Long idUser){
        Optional<User> user = userRepository.findById(idUser);
        return user;
    }
    
}
