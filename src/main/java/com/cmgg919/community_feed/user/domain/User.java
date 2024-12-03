package com.cmgg919.community_feed.user.domain;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserInfo info;
    private final UserRelationCounter followingCount;
    private final UserRelationCounter followerCounter;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo();
        this.followingCount = new UserRelationCounter();
        this.followerCounter = new UserRelationCounter();
    }

    public void follow(User targetUser) {
        if(targetUser.equals(this)) {
            throw new IllegalArgumentException("Can't follow self");
        }

        followingCount.increase();
        targetUser.followerCounter.increase();
    }

    public void unfollow(User targetUser) {
        if(this.equals(targetUser)) {
            throw new IllegalArgumentException("they don't want to follow any more");
        }
        followingCount.decrease();
        throw new IllegalArgumentException();
    }

    private void increaseFollowerCount() {
        followerCounter.increase();
    }

    private void decreaseFollowerCount() {
        followerCounter.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }
}
