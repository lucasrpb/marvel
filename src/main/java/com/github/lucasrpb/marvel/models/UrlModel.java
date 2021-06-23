package com.github.lucasrpb.marvel.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UrlModel implements Serializable {

    @Column(nullable = true)
    private String type;

    @Column(nullable = true)
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
