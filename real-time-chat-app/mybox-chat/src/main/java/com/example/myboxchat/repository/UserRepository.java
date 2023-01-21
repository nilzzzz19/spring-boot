package com.example.myboxchat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.myboxchat.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
    User findByUsername(String username);
    User findByEmail(String email);

}


/*
 * you don't need an implementation class for UserRepository. Spring Data
 * MongoDB provides a default implementation of the MongoRepository interface,
 * so you can simply define the interface and use it in your application without
 * having to create a separate implementation class.
 * 
 * By extending MongoRepository interface, Spring creates an implementation at
 * runtime using proxies, which gives you all the basic CRUD operations, such as
 * save, findAll, findById, and so on.
 * 
 * Additionally, if you have defined any custom methods in UserRepository as in
 * the previous example, Spring Data MongoDB will automatically create the
 * implementation for those methods at runtime as well.
 * 
 * This is known as the repository pattern, which is a way to separate the data
 * access logic from the business logic. The repository pattern is used to
 * create a bridge between the database and the application code.
 * 
 * It's important to note that you can also create your own implementation class
 * for the repository interface, but it's usually not necessary when using
 * Spring Data MongoDB.
 */