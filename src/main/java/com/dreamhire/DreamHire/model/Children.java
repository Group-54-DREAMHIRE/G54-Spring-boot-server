package com.dreamhire.DreamHire.model;

import lombok.Data;

import java.util.Date;

@Data
public class Children {
    private int key;
    private String title;
    private String link;
    private String subTitle;
    private String city;
    private String country;
    private Date start;
    private boolean hasStart;
    private boolean showStartMonth;
    private Date end;
    private boolean showEndMonth;
    private boolean present;
    private  Object description;
}
