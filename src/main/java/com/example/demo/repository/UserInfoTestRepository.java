package com.example.demo.repository;

import com.example.demo.model.UserInfoTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoTestRepository extends JpaRepository<UserInfoTest, Integer> {
    List<UserInfoTest> findByName(String name);
    /*
    List<UserInfoTest> findById(int id);

     */
}
