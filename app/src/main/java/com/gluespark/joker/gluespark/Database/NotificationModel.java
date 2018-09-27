package com.gluespark.joker.gluespark.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class NotificationModel {

    public NotificationModel(String pNotfTitle, String pNotfMessage, String pNotfImageUrl, Long pTimeStamp) {
        notfTitle = pNotfTitle;
        notfMessage = pNotfMessage;
        notfImageUrl = pNotfImageUrl;
        timeStamp = pTimeStamp;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "notf_id")
    private Integer notfId;

    @ColumnInfo(name = "notf_title")
    private String notfTitle;

    @ColumnInfo(name = "notf_message")
    private String notfMessage;

    @ColumnInfo(name = "notf_image_url")
    private String notfImageUrl;

    @ColumnInfo(name = "timestamp")
    private Long timeStamp;

    public String getNotfTitle() {
        return notfTitle;
    }

    public void setNotfTitle(String pNotfTitle) {
        notfTitle = pNotfTitle;
    }

    public String getNotfMessage() {
        return notfMessage;
    }

    public void setNotfMessage(String pNotfMessage) {
        notfMessage = pNotfMessage;
    }

    public String getNotfImageUrl() {
        return notfImageUrl;
    }

    public void setNotfImageUrl(String pNotfImageUrl) {
        notfImageUrl = pNotfImageUrl;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long pTimeStamp) {
        timeStamp = pTimeStamp;
    }
}
