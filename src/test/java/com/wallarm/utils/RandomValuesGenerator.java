package com.wallarm.utils;

import com.wallarm.configuration.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.GregorianCalendar;

import static java.lang.String.format;

public class RandomValuesGenerator {

    private static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());


    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }

    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length).toLowerCase();
    }

    public static String generatePassword (){
        String textPart = StringUtils.capitalize(generateRandomString(5) + RandomStringUtils.randomAscii(1));
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
