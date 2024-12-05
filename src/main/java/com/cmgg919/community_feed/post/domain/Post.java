package com.cmgg919.community_feed.post.domain;

import com.cmgg919.community_feed.common.domain.PositiveIntegerCounter;
import com.cmgg919.community_feed.post.domain.content.PostContent;
import org.apache.catalina.User;

public class Post {

    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;

    public Post(Long id, User author, PostContent content) {
        if(author == null) {
            throw new IllegalArgumentException("Author cannot be null");
         }

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user) {
        if(this.author.equals(user)) {
            throw new IllegalArgumentException("Cannot like more than one user");
        }
        likeCount.increase();
    }

    public void unlike(User user) {
        this.likeCount.decrease();
    }
    public void update(User user, String updatedContent) {
        if(!this.author.equals(user)) {
            throw new IllegalArgumentException("Cannot update more than one user");
        }
    }

}

   