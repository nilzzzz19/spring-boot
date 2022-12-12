package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Integer>{
//query table friends to display who is a best friend of who?
}
