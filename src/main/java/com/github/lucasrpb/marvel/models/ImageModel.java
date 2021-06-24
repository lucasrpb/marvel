package com.github.lucasrpb.marvel.models;

import javax.persistence.*;

@Embeddable
public class ImageModel {

    public ImageModel(){}

    public ImageModel(String path, String extension){
        this.path = path;
        this.extension = extension;
    }

    @Column(nullable = true)
    private String path;

    @Column(nullable = true)
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
