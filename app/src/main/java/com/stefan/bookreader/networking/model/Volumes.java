package com.stefan.bookreader.networking.model;


import java.math.BigDecimal;
import java.util.List;

public class Volumes {

    private Volumes(){
        //no instantiation
    }
    private String type;
    private List<Volume> items;

    public List<Volume> getItems() {
        return items;
    }

}
