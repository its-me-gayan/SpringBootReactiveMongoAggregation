package org.example.mongo.repository;

import org.example.mongo.entity.Customer;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:53 PM
 */
@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    @Aggregation({
            "{ $lookup:{ from: \"product\",localField: \"_id\",foreignField: \"cutomer_id\",as: \"productList\"}}",
            "{ $match: { \"productList.amount\": { $gte: ?0 }}}"
    })
     Flux<Customer> findAllCustomersWhoIsHavingOrdersWithAmountMoreThanEquals(Double amount);
}
