package entities;

import java.util.Date;
import java.util.List;

public class Podcast{
    private int podcastId;
    private String title;
    private String description;
    private String genre;
    private Date publishedDate;
    private Publisher publisher;
    private Director director;
    private Writer writer;
    private List<Actor> actors;
    private List<User> followers;

    public Podcast(String title, String description, Date publishedDate) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public Podcast(int podcastId, String title, String description, String genre, Date publishedDate) {
        this.podcastId = podcastId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.publishedDate = publishedDate;
    }
}