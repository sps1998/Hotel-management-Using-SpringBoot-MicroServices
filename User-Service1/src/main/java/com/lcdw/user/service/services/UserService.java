package com.lcdw.user.service.services;



import com.lcdw.user.service.entities.User;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);

    //Get all User
    List<User> getAllUser();

    //Get single user using UserId
    User getUser(String userId);






}

