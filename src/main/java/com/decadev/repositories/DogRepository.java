package com.decadev.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.decadev.entities.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepository {
    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public Dog save(Dog dog) {
        mapper.save(dog);
        return dog;
    }

    // Read
    public Dog findById(String id) {
        return mapper.load(Dog.class, id);
    }

    public List<Dog> findAll() {
        return mapper.scan(Dog.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, Dog dog) {
        mapper.save(dog,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return id;
    }

    // Delete
    public String delete(String id) {
        Dog dog = mapper.load(Dog.class, id);
        mapper.delete(dog);

        return "Dog successfully deleted: " + id;
    }
}
