package org.example.mongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 4:55 PM
 */
@Data
@Document(collection = "cutomer")
@ToString
public class Customer {
    @Id
    private String id;
    private String name;
    private String firstName;
    private Address address;
    private Set<String> hobbies;
}
@Data
@ToString
 class Address {
    private String ad_line_1;
    private String ad_line_2;
    private String ad_line_3;
    private String country;
}