package com.scorecalc.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sidney on 15-03-02.
 */
public class Input implements Serializable {
    private String id;
    private List<String> texts;

    public Input() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    @Override
    public String toString() {
        return "Input{" +
                "id='" + id + '\'' +
                ", texts=" + texts +
                '}';
    }
}
