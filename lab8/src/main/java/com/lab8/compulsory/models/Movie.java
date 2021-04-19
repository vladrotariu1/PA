package com.lab8.compulsory.models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Movie {
    private int id;
    private String title;
    private Date releaseDate;
    private float duration;
    private int score;

    public Movie(){};

    public Movie(int id, String title, Date releaseDate, int duration, int score){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public float getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
