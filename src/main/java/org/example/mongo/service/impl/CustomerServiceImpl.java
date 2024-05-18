package org.example.mongo.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mongo.entity.Customer;
import org.example.mongo.repository.CustomerRepository;
import org.example.mongo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:53 PM
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Mono<List<Customer>> getAllCustomer() {
        return customerRepository.findAll().collectList();
    }

    @Override
    public Mono<List<Customer>> findAllCustomersWhoIsHavingOrdersWithAmountMoreThanEquals(Double amount) {
        return customerRepository.findAllCustomersWhoIsHavingOrdersWithAmountMoreThanEquals(amount).doOnNext(customer -> System.out.println(customer)).collectList();
    }
}
