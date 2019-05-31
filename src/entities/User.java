package entities;

import java.util.Date;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private Date creationDate;
    private List<Podcast> podcasts;
}