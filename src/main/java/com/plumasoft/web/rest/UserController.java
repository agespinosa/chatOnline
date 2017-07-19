package com.plumasoft.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.plumasoft.entity.User;

import com.plumasoft.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
 
	@Autowired
	private UserRepository userRepository;
 
 
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAllUser() {
    	//if(true)throw new RuntimeException();
    	return this.userRepository.findAll();
    }
 
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable String id) {
        return this.userRepository.findOne(id);
    }
 
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createCustomer(@Valid  @RequestBody User uCreated) {
    	User created = this.userRepository.save(uCreated);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }
 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, 
    				 value = "{id}")
    public void updateUser( @PathVariable String id,
                           @RequestBody User user) {
        this.userRepository.save(user);
    }
 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, 
    				 value = "{id}")
    public void deleteUser(@PathVariable String id) {
    	this.userRepository.delete(id);
    }
 
   
}

