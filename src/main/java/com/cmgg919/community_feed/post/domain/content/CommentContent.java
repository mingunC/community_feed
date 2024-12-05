package com.cmgg919.community_feed.post.domain.content;

public class CommentContent extends Content {

    private static final int MAX_COMMENT_LENGTH = 100;

    public CommentContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException("Comment content must not be null or empty");
        }

        if(MAX_COMMENT_LENGTH < contentText.length()) {
            throw new IllegalArgumentException("Comment content must have at most " + MAX_COMMENT_LENGTH + " characters");
        }
    }
}
