package com.wallarm.utils;

import com.wallarm.configuration.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Strings;

import java.util.GregorianCalendar;
import java.util.Random;

import static java.lang.String.format;

public class RandomValuesGenerator {

    private static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());


    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();

    }

    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length).toLowerCase();
    }

    public static String generateSpecialCharactersString (int length){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        String specials = "~=+%^*/()[]{}/!@#$?|";
        for (int i = 0; i < length; i++){
            int number = random.nextInt(specials.length());
            char ch = specials.charAt(number);
            builder.append(ch);
        }
        return builder.toString();

    }

    public static String generatePassword (){
        String textPart = StringUtils.capitalize(generateRandomString(5) + generateSpecialCharactersString(1));
        String digitPart = generateRandomNumber(2);
        return textPart + digitPart;
    }

    public static String generateRandomMailinatorMail(){
      String template = userConfig.mailinatorTemplate();
        long unixTime = new GregorianCalendar().getTimeInMillis();
        return format(template, generateRandomString(4) + String.valueOf(unixTime).substring(2));

    }

    public static String generateRandomYandexMail(){
        String template = userConfig.yandexTemplate();
        long unixTime = new GregorianCalendar().getTimeInMillis();
        return format(template, generateRandomString(4) + String.valueOf(unixTime).substring(2));

    }

}
