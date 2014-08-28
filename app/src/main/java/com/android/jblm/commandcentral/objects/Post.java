package com.android.jblm.commandcentral.objects;

/**
 * Created by Brian on 2014
 */
public class Post {

    private String postTitle;
    private String postDesc;
    private String postDate;
    private String postURL;


    public Post(){
        //constructor
        postTitle = "test";
        postDesc = "test";
        postDate = "test";
        postURL = "test";
    };

    public void setPostTitle(String title){
        postTitle = title;
    }

    public String getPostTitle(){
        return postTitle;
    }

    public void setPostDate(String date) {
        postDate = date;
    }

    public void setPostDesc(String desc) {
        postDesc = desc;
    }

    public void setPostURL(String url) {
        postURL = url;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public String getPostURL() {
        return postURL;
    }
}