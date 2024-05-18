package org.example.mongo.handler;

import lombok.RequiredArgsConstructor;
import org.example.mongo.dto.AbstractResponse;
import org.example.mongo.entity.Customer;
import org.example.mongo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:43 PM
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerHandler {
    private final CustomerService customerService;
    public Mono<ServerResponse> getAllCustomer(ServerRequest request) {
        return customerService.getAllCustomer()
                .flatMap(this::buildSuccessResponse)
                .onErrorResume(this::buildExceptionResponse);
    }

    public Mono<ServerResponse> getAllFilteredCustomer(ServerRequest request) {
        double amount = request.queryParam("amount")
                .map(Double::parseDouble)
                .orElse(0.0);
        return customerService.findAllCustomersWhoIsHavingOrdersWithAmountMoreThanEquals(amount)
                .flatMap(this::buildSuccessResponse)
                .onErrorResume(this::buildExceptionResponse);
    }

    private Mono<ServerResponse> buildSuccessResponse(List<Customer> customers) {
        AbstractResponse abstractResponse = createAbstractResponse();
        abstractResponse.setMessageDescription("Query Success and Data retrieved successfully");
        abstractResponse.setMessage("Data retrieved successfully");
        abstractResponse.setHttpStatus(HttpStatus.OK);
        abstractResponse.setResponseCode(0);
        abstractResponse.setIsSuccess(true);
        abstractResponse.setData(customers);
        return ServerResponse.status(HttpStatus.OK).bodyValue(abstractResponse);
    }

    private Mono<ServerResponse> buildExceptionResponse(Throwable throwable) {
        AbstractResponse abstractResponse = createAbstractResponse();
        abstractResponse.setHttpStatus(HttpStatus.BAD_GATEWAY);
        abstractResponse.setResponseCode(999);
        abstractResponse.setMessage(throwable.getMessage());
        abstractResponse.setMessageDescription(throwable.getLocalizedMessage());
        abstractResponse.setIsSuccess(false);
        return ServerResponse.status(HttpStatus.BAD_GATEWAY).bodyValue(abstractResponse);
    }

    private AbstractResponse createAbstractResponse(){
        AbstractResponse abstractResponse = new AbstractResponse();
        abstractResponse.setTime(LocalDateTime.now());
        return abstractResponse;
    }
}
