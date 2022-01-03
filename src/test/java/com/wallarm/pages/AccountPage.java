package com.wallarm.pages;


import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.wallarm.enums.Urls.WALLARM_ACCOUNT_PAGE;

public class AccountPage extends BasePage{

    private static final String MAIN_ELEMENT = "[data-test-id='navigation.dashboard']";

    @Override
    protected String getMainPageElement() {
        return MAIN_ELEMENT;
    }

    @Override
    protected String getPageUrl() {
        return WALLARM_ACCOUNT_PAGE.getValue();
    }

    public boolean validateString(String... stringToValidate)
    {
        Pattern pat = Pattern.compile("([0-9]{1,3}\\,)*[0-9]{1,3}\\.[0-9]{2}");
        for(String stringItem: stringToValidate){
        Matcher m = pat.matcher(stringItem);
        if ( m.matches()){
           String firstPart = stringItem.split("\\.")[0];
          return firstPart.startsWith("0") && firstPart.length() > 1;
        }}
       return false;
    }
        /*
    Have the function formattedNumber(stringToValidate) take the single string parameter being passed,
    and return true if it is in a valid currency format that contains only digits with
     properly placed decimals and commas, otherwise return false. For example: if stringToValidate is [“1,093,222.04”]
      then your program should return  true, but if the input were [“1,093,22.04"] then your program should return false.
      The input may contain characters other than digits.
True for:

“1,234,567.89”,
“23,343.54”,
“10.45”,
“234.54”,
“0.46”,
“434,234,676,345,675.99”
False for:

“56”,
“10.4”,
“3.433.434.53”
“D323”,
“Jds,dsf,dfd.ef”,
“1,410.453”,
“0,344,554.43”,
“3,54,333”
“000.34”
     */

}
