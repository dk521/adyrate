package com.gluespark.joker.gluespark.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class TransactionModel {

    @PrimaryKey @NonNull
    @ColumnInfo(name = "trans_id")
    private Integer transId;
    @ColumnInfo(name = "trans_from")
    private String transFrom;
    @ColumnInfo(name = "trans_to")
    private String transTo;
    @ColumnInfo(name = "trans_timestamp")
    private String transTimeStamp;
    @ColumnInfo(name = "trans_amount")
    private Integer transAmount;

    public TransactionModel(@NonNull Integer pTransId, String pTransFrom, String pTransTo, String pTransTimeStamp, Integer pTransAmount) {
        transId = pTransId;
        transFrom = pTransFrom;
        transTo = pTransTo;
        transTimeStamp = pTransTimeStamp;
        transAmount = pTransAmount;
    }

    @NonNull
    public Integer getTransId() {
        return transId;
    }

    public void setTransId(@NonNull Integer pTransId) {
        transId = pTransId;
    }

    public String getTransFrom() {
        return transFrom;
    }

    public void setTransFrom(String pTransFrom) {
        transFrom = pTransFrom;
    }

    public String getTransTo() {
        return transTo;
    }

    public void setTransTo(String pTransTo) {
        transTo = pTransTo;
    }

    public String getTransTimeStamp() {
        return transTimeStamp;
    }

    public void setTransTimeStamp(String pTransTimeStamp) {
        transTimeStamp = pTransTimeStamp;
    }

    public Integer getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Integer pTransAmount) {
        transAmount = pTransAmount;
    }
}
