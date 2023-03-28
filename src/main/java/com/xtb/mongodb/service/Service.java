package com.xtb.mongodb.service;

import com.mongodb.client.MongoClient;
import com.xtb.mongodb.model.Seller;
import com.xtb.mongodb.model.Sellers;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class Service {
    @Autowired
    MongoTemplate mongoTemplate;

    private static Log logger = LogFactory.getLog(Service.class);

    public void test1(){
        Boolean ee = mongoTemplate.collectionExists("user");
        if(ee){
            logger.warn("Exist.");
            logger.warn(mongoTemplate.getCollectionNames().toString());

        }
        Query query = new Query();
        query.addCriteria(Criteria.where("gender").is("male"));
        List<Seller> sellerList = mongoTemplate.find(query, Seller.class);
        for(Seller i: sellerList){
            logger.warn("Exist. "+ i.toString());
        }

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("gender").is("male"));
        List<Sellers> sellerList1 = mongoTemplate.find(query, Sellers.class);
        for(Sellers i: sellerList1){
            logger.warn("Exist. "+ i.toString());
        }
    }


}
