package com.android.jblm.commandcentral.objects;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Brian on 2014.
 */
public class Directory {
    private final Date xmlDate;

    private Boolean getUpdate;
    private final ArrayList<Header> headers;

    public Directory(){
        headers = new ArrayList<Header>();
        xmlDate = null;
        getUpdate = false;
    }



    public Header[] getHeaders() {
        return (Header[])headers.toArray(new Header[headers.size()]);
    }

    public void addHeader(Header h){
        headers.add(h);
    }

    public Date getXmlDate() {
        return xmlDate;
    }

    public Boolean getUpdate() {
        if(getUpdate){
            return true;
        }
        checkUpdate();
        return getUpdate;
    }

    public void setUpdate(Boolean update) {
        getUpdate = update;
    }

    //Check to see if 30 days have passed since the XML file was created
    private boolean checkUpdate(){

        Date today = new Date();

        Long diff = today.getTime() - xmlDate.getTime();

        if((diff / (1000 * 60 * 60 * 24)) >= 30){
            getUpdate = true;
            return true;
        } else {
            return false;
        }
    }
}
