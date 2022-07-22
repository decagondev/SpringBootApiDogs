package com.decadev.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.decadev.entities.AsylumCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AsylumCaseRepository {
    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public AsylumCase save(AsylumCase ac) {
        mapper.save(ac);
        return ac;
    }

    // Read
    public AsylumCase findById(String id) {
        return mapper.load(AsylumCase.class, id);
    }

    public List<AsylumCase> findAll() {
        return mapper.scan(AsylumCase.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, AsylumCase ac) {
        mapper.save(ac,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return id;
    }

    // Delete
    public String delete(String id) {
        AsylumCase ac = mapper.load(AsylumCase.class, id);
        mapper.delete(ac);

        return "Dog successfully deleted: " + id;
    }
}
