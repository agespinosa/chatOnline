package com.plumasoft.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.plumasoft.entity.User;;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByNombre(String nombre);
    public List<User> findByApellido(String apellido);

}