package com.cmgg919.community_feed.user.domain;

import com.cmgg919.community_feed.common.domain.PositiveIntegerCounter;

import java.util.Objects;

public class User {
    private final Long id;
    private final UserInfo info;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCounter;

    public User(Long id, UserInfo info, PositiveIntegerCounter followingCount, PositiveIntegerCounter followerCounter) {
        this.id = id;
        this.info = info;
        this.followingCount = followingCount;
        this.followerCounter = followerCounter;
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
