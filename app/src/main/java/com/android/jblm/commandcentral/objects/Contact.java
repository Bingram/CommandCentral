package com.android.jblm.commandcentral.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian 2014.
 */
public class Contact {
    public  String contactName;
    public  List<String> phoneNumbers;
    public  String contactEmail;
    public  String contactURL;
    public  String contactDesc;

    public Contact(){
        contactName = "";
        phoneNumbers = new ArrayList<String>();
        contactEmail = "";
        contactURL = "";
        contactDesc = "";
    }

    public Contact(String name, List<String> phone, String email, String web,String desc){
        contactName = name;
        phoneNumbers = phone;
        contactEmail = email;
        contactURL = web;
        contactDesc = desc;
    }

    public void addNumber(String number){
        phoneNumbers.add(number);
    }
}
