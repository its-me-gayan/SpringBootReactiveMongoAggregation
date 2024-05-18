package org.example.mongo.router;

import org.example.mongo.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:43 PM
 */

@Configuration
public class CustomerRouter {

    @Bean
    public RouterFunction<ServerResponse> route(CustomerHandler customerHandler){
        return RouterFunctions.route()
                .GET("/api/v1/customer", customerHandler::getAllCustomer)
                .GET("/api/v1/customer/filter", customerHandler::getAllFilteredCustomer)
                .build();

    }
}
