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

import com.plumasoft.entity.Customer;
import com.plumasoft.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
 
	@Autowired
	private CustomerRepository customerRepository;
 
 
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> getAllCustomer() {
    	//if(true)throw new RuntimeException();
    	return this.customerRepository.findAll();
    }
 
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer(@PathVariable String id) {
        return this.customerRepository.findOne(id);
    }
 
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@Valid  @RequestBody Customer cCreated) {
        Customer created = this.customerRepository.save(cCreated);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }
 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")

    public void updateCustomer( @PathVariable String id,
                           @RequestBody Customer customer) {
        this.customerRepository.save(customer);
    }
 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteCustomer(@PathVariable String id) {
    	this.customerRepository.delete(id);
    }
 
   
}
