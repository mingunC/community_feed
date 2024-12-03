package com.cmgg919.community_feed.post.domain.content;

public class PostContent extends Content {

    private static final int MIN_POST_LENGTH = 5;
    private static final int MAX_POST_LENGTH = 500;

    public PostContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException("Content text cannot be null or empty");
        }

        if(contentText.length() > MAX_POST_LENGTH) {
            throw new IllegalArgumentException("Content text is too long");
        }

        if(contentText.length() < MIN_POST_LENGTH) {
            throw new IllegalArgumentException("Content text is too short");
        }

    }


}
