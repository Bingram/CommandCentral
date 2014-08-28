package com.android.jblm.commandcentral.objects;

import java.util.ArrayList;

/**
 * Created by Brian 2014.
 */
public class Category {

    private final String title;
    private final ArrayList<Contact> contacts;

    public Category(){
        title = "";
        contacts = new ArrayList<Contact>();
    }

    public Category(String name){
        title = name;
        contacts = new ArrayList<Contact>();
    }

    public Category(String name, ArrayList<Contact> listings){
        title = name;
        contacts = listings;
    }

    public Contact[] getContacts() {
        return (Contact[])contacts.toArray(new Contact[contacts.size()]);
    }

    public void addContact(Contact c){
        contacts.add(c);
    }

    public String getTitle() {
        return title;
    }
}
