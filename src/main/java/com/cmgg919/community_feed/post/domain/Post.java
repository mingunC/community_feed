package com.cmgg919.community_feed.post.domain;

import com.cmgg919.community_feed.post.domain.content.PostContent;
import org.apache.catalina.User;

public class Post {

    private final Long id;
    private final User author;
    private final PostContent content;


    public Post(Long id, User author, PostContent content) {
        if(author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }


        this.id = id;
        this.author = author;
        this.content = content;
    }
}
