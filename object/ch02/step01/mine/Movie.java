package com.sh.object.ch02.step01.mine;

import com.sh.object.ch02.step01.mine.enumClazz.Genre;

public class Movie {

    private String title;
    private Genre genre;
    private Integer ScreeningTime;  // 분 단위
    private Integer fee;
    private Boolean subtitle; // 자막 유무

    public Movie(String title, Genre genre, Integer screeningTime, Integer fee, Boolean subtitle) {
        this.title = title;
        this.genre = genre;
        ScreeningTime = screeningTime;
        this.fee = fee;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getScreeningTime() {
        return ScreeningTime;
    }

    private void setScreeningTime(Integer screeningTime) {
        ScreeningTime = screeningTime;
    }

    public Integer getFee() {
        return fee;
    }

    private void setFee(Integer fee) {
        this.fee = fee;
    }

    public Boolean getSubtitle() {
        return subtitle;
    }

    private void setSubtitle(Boolean subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", ScreeningTime=" + ScreeningTime +
                ", fee=" + fee +
                ", subtitle=" + subtitle +
                '}';
    }
}
