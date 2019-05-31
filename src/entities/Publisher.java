package entities;

import java.util.Date;
import java.util.List;

public class Publisher{
    private int publisherId;
    private String publishername;
    private String password;
    private String email;
    private Date creationDate;
    private List<Podcast> podcasts;
}