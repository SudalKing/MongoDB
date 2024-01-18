package com.sudal.mongodb.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final MongoTemplate mongoTemplate;

    public String create(String name) {
        User user = User.builder()
                .name(name)
                .build();

        return mongoTemplate.insert(user, "user").getId();
    }

    public User read(String id) {
        Query query = new Query(Criteria.where("id").is(id));

        return mongoTemplate.findOne(query, User.class, "user");
    }

    public User update(String id, String name) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("name", name);

        return mongoTemplate.findAndModify(query, update, User.class, "user");
    }

    public void delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));

        mongoTemplate.remove(query, User.class, "user");
    }
}
