package com.github.lucasrpb.marvel.api.models;

import java.util.List;

public class CharacterDataContainer {

    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<MarvelCharacter> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MarvelCharacter> getResults() {
        return results;
    }

    public void setResults(List<MarvelCharacter> results) {
        this.results = results;
    }
}
