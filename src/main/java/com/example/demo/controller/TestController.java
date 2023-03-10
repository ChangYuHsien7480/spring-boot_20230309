package com.example.demo.controller;


import com.example.demo.model.UserInfoTest;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/userInfo") // create userinfo table
    public UserInfoTest saveUserInfo(@RequestBody UserInfoTest userInfoTest) {
        return this.testService.saveUserInfo(userInfoTest);
    }

    @PostMapping("/findByName") // find by name
    public List<Integer> findByName(@RequestBody String name){
        return this.testService.findByName(name);
    }

    @DeleteMapping(value = "/deleteById") // delete by id
    public Integer deleteById(@RequestParam Integer id) throws Exception{
        return this.testService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Map<String, Object> findById(@PathVariable Integer id) {
        return this.testService.findById(id);
    }

    @DeleteMapping("/deleteById_TestRepo")
    public Integer deleteById_TestRepo(@RequestParam Integer id)throws Exception{return this.testService.deleteById_TestRepo(id);}

    @PostMapping("/insertUserInfo_TestRepo")
    public String insertUserInfo(@RequestParam String name){
        return this.testService.insertUserInfo(name);
    }

}
