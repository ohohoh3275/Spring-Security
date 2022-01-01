package com.jiyeon.project.service;

import com.jiyeon.project.domain.User;
import com.jiyeon.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> findByUserId(Long userId){

        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<User> userList = mongoTemplate.find(query, User.class);

        //hi
        return userList;
    }

    public List<User> findByUserIdNativeQuery(Long userId){

        String sql = "select * from ";

        return null;
    }

}
