package com.wallarm.utils;

import com.wallarm.entities.User;


public class UserGenerator {


    public static User generateRandomUserProfileWithMailinator(){
        User user = new User();
        user.setFirstName(RandomValuesGenerator.generateRandomString(6));
        user.setCompanyName(RandomValuesGenerator.generateRandomString(6));
        user.setPosition(RandomValuesGenerator.generateRandomString(6));
        user.setLastName(RandomValuesGenerator.generateRandomString(6));
        user.setPassword(RandomValuesGenerator.generatePassword());
        user.setPhone(RandomValuesGenerator.generateRandomNumber(8));
        user.setEmail(RandomValuesGenerator.generateRandomMailinatorMail());
        return user;
    }

    public static User generateRandomUserProfileWithYandexMail(){
        User user = new User();
        user.setFirstName(RandomValuesGenerator.generateRandomString(6));
        user.setCompanyName(RandomValuesGenerator.generateRandomString(6));
        user.setPosition(RandomValuesGenerator.generateRandomString(6));
        user.setLastName(RandomValuesGenerator.generateRandomString(6));
        user.setPhone(RandomValuesGenerator.generateRandomNumber(8));
        user.setPassword(RandomValuesGenerator.generatePassword());
        user.setEmail(RandomValuesGenerator.generateRandomYandexMail());
        return user;
    }

}
