package com.example.amirz.secondattempt;

/**
 * Created by amirz on 1/17/2018.
 */

public class ResponseModel {
    private String[] text;
    private String lang;
    private int key;

   // here we specify getter methods for the language , key and text


    public String[] getText() {
        return text;
    }
    public String getLang() {
        return lang;
    }
    public int getKey() {
        return key;
    }
}
