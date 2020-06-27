package br.com.vouviajar.vouviajarapirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajarapirest.dto.UserCredentialsDTO;
import br.com.vouviajar.vouviajarapirest.models.User;
import br.com.vouviajar.vouviajarapirest.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserCredentialsDTO> getById(@PathVariable Long id ){
    	Optional<User> user = userService.getById(id);
    	if(user.isEmpty()) {
        	return new ResponseEntity<UserCredentialsDTO>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<UserCredentialsDTO>(UserCredentialsDTO.toDTO(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll(){
    	List<User> users = userService.getAll();
    	if(users.isEmpty()) {
        	return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
    	}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserCredentialsDTO> register(@RequestBody UserCredentialsDTO userCredentialsDTO){
        User user = userService.register(userCredentialsDTO.toUser());
        return  new ResponseEntity<UserCredentialsDTO>(UserCredentialsDTO.toDTO(user), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserCredentialsDTO> update(@RequestBody UserCredentialsDTO userCredentialsDTO, @PathVariable Long id ){
    	User user = userService.update(userCredentialsDTO.toUser(), id);    	
    	return  new ResponseEntity<UserCredentialsDTO>(UserCredentialsDTO.toDTO(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserCredentialsDTO> delete(@PathVariable Long id ){
    	userService.delete(id);    	
    	return  new ResponseEntity<>( HttpStatus.OK);
    }

}