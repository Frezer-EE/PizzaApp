package com.example.pizza;

public class MarkerSettings {
    private String drawableName, title, snippet;
    private Double latitude, longitude;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getDrawableName() {
        return drawableName;
    }

    public MarkerSettings(String drawableName, String title, String snippet, Double latitude, Double longitude) {
        this.drawableName = drawableName;
        this.title = title;
        this.snippet = snippet;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setDrawableName(String drawableName) {
        this.drawableName = drawableName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
