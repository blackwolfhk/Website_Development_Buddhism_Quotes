package com.example.buddhism_quotes_server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String chiDescription;
    private String engDescription;

    public Item() {
    }

    public Item(String chiDescription, String engDescription) {
        this.chiDescription = chiDescription;
        this.engDescription = engDescription;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return chiDescription + " - " + engDescription;
    }

    public String getChiDescription() {
        return chiDescription;
    }

    public void setChiDescription(String chiDescription) {
        this.chiDescription = chiDescription;
    }

    public String getEngDescription() {
        return engDescription;
    }

    public void setEngDescription(String engDescription) {
        this.engDescription = engDescription;
    }
}
