package com.moviesexplorer.movie;

import jakarta.annotation.Nullable;

import java.time.LocalDate;

public class MovieImage {
    private Long id;
    private String name;
    private String alternativeText;
    private String caption;
    private int width;
    private int height;
    private ImageFormats formats;
    private String hash;
    private String ext;
    private String mime;
    private int size;
    private String url;
    private String previewUrl;
    private String provider;
    @Nullable
    private String provider_metadata;
    private LocalDate created_at;
    private LocalDate updated_at;

    public MovieImage(Long id, String name, String alternativeText, String caption, int width, int height, ImageFormats formats, String hash, String ext, String mime, int size, String url, String previewUrl, String provider, @Nullable String provider_metadata, LocalDate created_at, LocalDate updated_at) {
        this.id = id;
        this.name = name;
        this.alternativeText = alternativeText;
        this.caption = caption;
        this.width = width;
        this.height = height;
        this.formats = formats;
        this.hash = hash;
        this.ext = ext;
        this.mime = mime;
        this.size = size;
        this.url = url;
        this.previewUrl = previewUrl;
        this.provider = provider;
        this.provider_metadata = provider_metadata;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternativeText() {
        return alternativeText;
    }

    public void setAlternativeText(String alternativeText) {
        this.alternativeText = alternativeText;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
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

    public ImageFormats getFormats() {
        return formats;
    }

    public void setFormats(ImageFormats formats) {
        this.formats = formats;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Nullable
    public String getProvider_metadata() {
        return provider_metadata;
    }

    public void setProvider_metadata(@Nullable String provider_metadata) {
        this.provider_metadata = provider_metadata;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}
