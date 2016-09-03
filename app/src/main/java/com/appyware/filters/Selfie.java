package com.appyware.filters;

import java.io.Serializable;

/**
 * Created by
 * --Vatsal Bajpai on
 * --03/09/16 at
 * --6:47 AM
 */
public class Selfie implements Serializable {

    String name;
    String path;

    public Selfie(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
