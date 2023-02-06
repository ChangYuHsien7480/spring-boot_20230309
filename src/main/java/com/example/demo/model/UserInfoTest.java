package com.example.demo.model;

import javax.persistence.*;

@Table(name = "user_info_test")
@Entity(name = "user_info_test")
public class UserInfoTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // postgresql pk sequence

    private String name;

    public Integer getId() {
        return id;
    }

    public UserInfoTest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfoTest setName(String name) {
        this.name = name;
        return this;
    }
}
