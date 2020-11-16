package com.example.moviep22;

public class MovieModel {
    private String title;
    private String description;
    private String rating;
    private String streamingLink;
    private String studio;
    private int thumbnial ;

    public MovieModel(String title, int thumbnial) {
        this.title = title;
        this.thumbnial = thumbnial;
    }

    public MovieModel(String title, String description, String rating, String streamingLink, String studio, int thumbnial) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.streamingLink = streamingLink;
        this.studio = studio;
        this.thumbnial = thumbnial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getThumbnial() {
        return thumbnial;
    }

    public void setThumbnial(int thumbnial) {
        this.thumbnial = thumbnial;
    }
}

