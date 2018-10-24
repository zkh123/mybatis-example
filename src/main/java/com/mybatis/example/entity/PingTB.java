package com.mybatis.example.entity;

import java.io.Serializable;
import java.util.Date;

public class PingTB implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private int userid;
    private int listingid;
    private int bizid;
    private int zuid;
    private int dingid;
    private int months;
    private float creditScore;
    private String creditLevel;
    private int creditBin;
    private String creditLevelPro;
    private String modelLabel;
    private String modelVer;
    private int processFlag;
    private int blockDays;
    private String info;
    private Date insertTime;
    private Date updateTime;
    private int isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getListingid() {
        return listingid;
    }

    public void setListingid(int listingid) {
        this.listingid = listingid;
    }

    public int getBizid() {
        return bizid;
    }

    public void setBizid(int bizid) {
        this.bizid = bizid;
    }

    public int getZuid() {
        return zuid;
    }

    public void setZuid(int zuid) {
        this.zuid = zuid;
    }

    public int getDingid() {
        return dingid;
    }

    public void setDingid(int dingid) {
        this.dingid = dingid;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(float creditScore) {
        this.creditScore = creditScore;
    }

    public String getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    public int getCreditBin() {
        return creditBin;
    }

    public void setCreditBin(int creditBin) {
        this.creditBin = creditBin;
    }

    public String getCreditLevelPro() {
        return creditLevelPro;
    }

    public void setCreditLevelPro(String creditLevelPro) {
        this.creditLevelPro = creditLevelPro;
    }

    public String getModelLabel() {
        return modelLabel;
    }

    public void setModelLabel(String modelLabel) {
        this.modelLabel = modelLabel;
    }

    public String getModelVer() {
        return modelVer;
    }

    public void setModelVer(String modelVer) {
        this.modelVer = modelVer;
    }

    public int getProcessFlag() {
        return processFlag;
    }

    public void setProcessFlag(int processFlag) {
        this.processFlag = processFlag;
    }

    public int getBlockDays() {
        return blockDays;
    }

    public void setBlockDays(int blockDays) {
        this.blockDays = blockDays;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
