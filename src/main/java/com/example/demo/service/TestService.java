package com.example.demo.service;

import com.example.demo.model.UserInfoTest;
import com.example.demo.repository.TestRepo;
import com.example.demo.repository.UserInfoTestRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TestService {

    @Autowired
    private UserInfoTestRepository userInfoTestRepository;

    @Autowired
    private TestRepo testRepo;


    public UserInfoTest saveUserInfo(UserInfoTest userInfoTest) {
        userInfoTest = userInfoTest.setId(null);
        this.userInfoTestRepository.saveAndFlush(userInfoTest);
        return userInfoTest;
    }

    // restful API

    // findAll
    public List<UserInfoTest> findAll() {
        return this.userInfoTestRepository.findAll();
    }

    public Map<String, Object> findById(Integer id) {
        return this.testRepo.findById(id);
    }

    // find by name
    public List<Integer> findByName(String name){
        List<Integer> result = new ArrayList<>();
        List<UserInfoTest> userInfoTests = this.userInfoTestRepository.findByName(name);
        for(int i  = 0; i < userInfoTests.size(); i++){
            result.add(userInfoTests.get(i).getId());
        }
        return result;
    }

    //update by id

//    public String updateById(Integer id,String name){
//        List<UserInfoTest> userInfoTests = this.userInfoTestRepository.findById(id);
//        Optional<UserInfoTest> userInfoTestChk = this.userInfoTestRepository.findById(id);
//        UserInfoTest userInfoTest = null;
//        if (userInfoTestChk.isPresent()) {
//            userInfoTest = userInfoTestChk.get();
//        } else {
//            return "not found";
//        }
//
//        userInfoTest = userInfoTest.setName(name);
//        this.userInfoTestRepository.saveAndFlush(userInfoTest);
//        return "success";
//    }


    //delete by id
    @Transactional
    public Integer deleteById(Integer id) throws Exception{
//        throw new Exception("Hello");
        try {
            this.userInfoTestRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            // 做一些很酷的事
            return  null;
        }
        return 1;
    }

    //delete by id <- testRepo
    public Integer deleteById_TestRepo(Integer id){
        return this.testRepo.deleteById_TestRepo(id);
    }
}
