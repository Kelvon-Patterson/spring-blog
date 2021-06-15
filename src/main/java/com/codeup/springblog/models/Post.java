package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 225)
    private String body;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;


    public Post(){

    }
//insert constructor
    public Post(String title, String body) {

    this.title = title;
    this.body = body;
}
        //update constructor
    public Post(long id, String title, String body, List<PostImage> images) {
        this.id = id;
        this.title=title;
        this.body=body;
        this.images= images;
    }

    //create constructor
    public Post(String title, String body, User user, List<PostImage> images){
        this.title=title;
        this.body=body;
        this.user=user;
        this.images=images;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public Post(long id, String title, String body) {
        this.id=id;
        this.title=title;
        this.body=body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
