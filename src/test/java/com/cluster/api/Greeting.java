package com.cluster.api;

/**
 * Created by shane on 2/16/17.
 * <p>
 * Example of how a RESTful API Service is created
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
