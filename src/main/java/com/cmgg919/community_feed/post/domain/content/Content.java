package com.cmgg919.community_feed.post.domain.content;

import com.cmgg919.community_feed.post.domain.common.DatetimeInfo;

public abstract class Content {

    String contentText;
    final DatetimeInfo datetimeInfo;


   protected Content(String contentText, DatetimeInfo datetimeInfo) {
       checkText(contentText);
       this.contentText = contentText;
       this.datetimeInfo = datetimeInfo;
   }

    public void updateContent(String updateContent) {
        checkText(updateContent);
        this.contentText = updateContent;
        this.datetimeInfo.updateEditDatetime();
    }
   protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
