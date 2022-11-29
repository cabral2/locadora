package Models;

import java.util.Date;

public class Movie {
    private int id;
    private String name;
    private String director;
    private Date releaseYear;
    private String description;
    private String category;

    public Movie(int id, String name, String director, Date releaseYear, String description, String category) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
        this.description = description;
        this.category = category;
    }

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
