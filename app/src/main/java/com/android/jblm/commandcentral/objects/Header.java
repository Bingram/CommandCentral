package com.android.jblm.commandcentral.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian 2014.
 */
public class Header {
    private final String name;
    private final List<Category> categories;

    public Header(){
        name = "";
        categories = new ArrayList<Category>();
    }

    public Header(String title){
        name = title;
        categories = new ArrayList<Category>();
    }

    public String getName() {
        return name;
    }

    public void addCategory(Category c){
        categories.add(c);
    }

    public Category[] getCategories() {
        return (Category[]) categories.toArray(new Category[categories.size()]);
    }
}

