package com.moviesexplorer.movie;

public class ImageFormats {
    private SmallFormat thumbnail;
    private SmallFormat small;

    public ImageFormats(SmallFormat thumbnail, SmallFormat small) {
        this.thumbnail = thumbnail;
        this.small = small;
    }

    public SmallFormat getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(SmallFormat thumbnail) {
        this.thumbnail = thumbnail;
    }

    public SmallFormat getSmall() {
        return small;
    }

    public void setSmall(SmallFormat small) {
        this.small = small;
    }
}
