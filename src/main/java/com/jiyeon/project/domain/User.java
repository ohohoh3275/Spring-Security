package com.jiyeon.project.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Document("users")
@Getter
@Setter
public class User {

    @Id
    private String _id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Long age;

    @Column(name="userid")
    private Long userId;
}
