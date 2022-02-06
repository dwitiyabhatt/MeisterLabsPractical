package com.example.darshanpractical.models.pojo;

import androidx.annotation.NonNull;

public class Filter {
    String text;
    private int[] statues;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getStatues() {
        return statues;
    }

    public void setStatues(int[] statues) {
        this.statues = statues;
    }
}
