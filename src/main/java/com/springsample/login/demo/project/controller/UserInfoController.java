package com.springsample.login.demo.project.controller;


import com.springsample.login.demo.project.database.repo.UserInfoRepo;
import com.springsample.login.demo.project.database.tables.UserInfoTab;
import com.springsample.login.demo.project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserInfoController {



    @Autowired
    UserInfoRepo userInfoRepo;


    @GetMapping("/user")
    public List<UserInfoTab> getAllUserInfo(){
        return userInfoRepo.findAll();
    }


    @PostMapping("/user")
    public UserInfoTab postUserInfo(@Valid @RequestBody UserInfoTab userInfoTab){
        userInfoTab.setCreatedDate(new Date());
        userInfoTab.setModifiedDate(new Date());
        return userInfoRepo.save(userInfoTab);
    }


    @GetMapping("/user/{id}")
    public UserInfoTab getUserById(@PathVariable(value = "id") Long userId) {
        return userInfoRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }


    @PostMapping("/userlogin")
    public UserInfoTab getUserByuserpass(@RequestBody UserInfoTab userInfoTab) {
        return userInfoRepo.findByuserpass(userInfoTab.getUSERNAME(), userInfoTab.getPASSWORD()).get(0);
    }



    @PutMapping("/user/{id}")
    public UserInfoTab updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody UserInfoTab userDetails) {

        UserInfoTab userinfo = userInfoRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        if(userDetails.getPASSWORD()!=null) {
            userinfo.setPASSWORD(userDetails.getPASSWORD());
        }
        if(userDetails.getDOB()!=null) {
            userinfo.setDOB(userDetails.getDOB());
        }
        userinfo.setModifiedDate(new Date());

        return userInfoRepo.save(userinfo);
    }



    @DeleteMapping("/Users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long UserId) {
        UserInfoTab User = userInfoRepo.findById(UserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));

        userInfoRepo.delete(User);
        return ResponseEntity.ok().build();
    }
}
