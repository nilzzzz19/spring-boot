package com.example.myboxchat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.myboxchat.model.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

    Group findByName(String name);
}

