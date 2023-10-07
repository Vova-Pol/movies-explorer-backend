package com.moviesexplorer.movie;

import jakarta.annotation.Nullable;

public class SmallFormat {
    private String hash;
    private String ext;
    private String mime;
    private int width;
    private int height;
    private int size;
    @Nullable
    private String path;
    private String url;

    public SmallFormat(String hash, String ext, String mime, int width, int height, int size, @Nullable String path, String url) {
        this.hash = hash;
        this.ext = ext;
        this.mime = mime;
        this.width = width;
        this.height = height;
        this.size = size;
        this.path = path;
        this.url = url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Nullable
    public String getPath() {
        return path;
    }

    public void setPath(@Nullable String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
