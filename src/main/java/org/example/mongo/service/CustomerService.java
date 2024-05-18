package org.example.mongo.service;

import org.example.mongo.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:53 PM
 */
public interface CustomerService {
    Mono<List<Customer>> getAllCustomer();
    Mono<List<Customer>> findAllCustomersWhoIsHavingOrdersWithAmountMoreThanEquals(Double amount);
}
