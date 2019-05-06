package com.latihan.dicoding.moviecatalogue3.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    private Integer id;
    private String title;
    private String posterPath;
    private String overview;
    private String releaseDate;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

   public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

   public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterLink() {
        return ("http://image.tmdb.org/t/p/w185"+ posterPath);
    }

   public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }

   public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Movie(JSONObject object) {
        try {
            this.id = object.getInt("id");
            this.title = object.getString("title");
            this.overview = object.getString("overview");
            this.releaseDate = object.getString("release_date");
            this.posterPath = ("http://image.tmdb.org/t/p/w1850" + object.getString("poster_path"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
