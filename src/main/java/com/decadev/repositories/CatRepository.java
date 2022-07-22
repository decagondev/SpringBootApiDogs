package com.decadev.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.decadev.entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepository {

    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public Cat save(Cat cat) {
        mapper.save(cat);
        return cat;
    }

    // Read
    public Cat findById(String id) {
        return mapper.load(Cat.class, id);
    }

    public List<Cat> findAll() {
        return mapper.scan(Cat.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, Cat cat) {
        mapper.save(cat,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return id;
    }

    // Delete
    public String delete(String id) {
        Cat cat = mapper.load(Cat.class, id);
        mapper.delete(cat);

        return "Cat successfully deleted: " + id;
    }
}
