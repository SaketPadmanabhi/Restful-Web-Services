package com.socialchat.rest.webservices.restfulwebservices.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Description should be atleast 2 characters")
    private String description;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)    // this association is lazyly fetched i.e. we do not want user details to be fetched
    @JsonIgnore
    private User user;

    public Post() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
}
