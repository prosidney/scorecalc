package com.scorecalc.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Created by Sidney on 15-03-02.
 */
public class Input implements Serializable {
    private String id;

    public Input() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
