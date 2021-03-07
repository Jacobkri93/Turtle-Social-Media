package com.example.demo.models;

import org.springframework.core.style.ToStringCreator;
import org.w3c.dom.DOMStringList;

public class Post {
    public String title;
    public String content;
    public String visibility;
    public String gender;



    public Post(String title, String content, String visibility, String gender) {
        this.title = title;
        this.content = content;
        this.visibility = visibility;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", visibility='" + visibility + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
