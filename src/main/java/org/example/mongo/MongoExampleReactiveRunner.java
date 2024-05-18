package org.example.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:35 PM
 */
@SpringBootApplication
@EnableWebFlux
public class MongoExampleReactiveRunner{
    public static void main(String[] args) {
        SpringApplication.run(MongoExampleReactiveRunner.class , args);
    }
}
