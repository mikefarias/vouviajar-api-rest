package br.com.vouviajar.vouviajarapirest.controller;

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
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserCredentialsDTO> register(@RequestBody UserCredentialsDTO userCredentialsDTO){
        User user = userService.register(userCredentialsDTO.toUser());
        return  new ResponseEntity<UserCredentialsDTO>(UserCredentialsDTO.toDTO(user), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserCredentialsDTO> update(@RequestBody UserCredentialsDTO userCredentialsDTO, @PathVariable Long id ){
    	User user = userService.update(userCredentialsDTO.toUser(), id);    	
    	return  new ResponseEntity<UserCredentialsDTO>(UserCredentialsDTO.toDTO(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserCredentialsDTO> delete(@RequestBody UserCredentialsDTO userCredentialsDTO, @PathVariable Long id ){
    	User user = userService.update(userCredentialsDTO.toUser(), id);    	
    	return  new ResponseEntity<UserCredentialsDTO>(UserCredentialsDTO.toDTO(user), HttpStatus.CREATED);
    }

}