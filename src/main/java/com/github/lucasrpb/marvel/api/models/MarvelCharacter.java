package com.github.lucasrpb.marvel.api.models;

import com.github.lucasrpb.marvel.models.ImageModel;
import com.github.lucasrpb.marvel.models.UrlModel;

import java.util.Date;
import java.util.List;

public class MarvelCharacter {

    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<UrlModel> urls;
    private ImageModel thumbnail;
    private ComicList comics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<UrlModel> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlModel> urls) {
        this.urls = urls;
    }

    public ImageModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ComicList getComics() {
        return comics;
    }

    public void setComics(ComicList comics) {
        this.comics = comics;
    }
}
