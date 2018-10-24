package com.mybatis.example.utils;

/**
 * Created by huanglijun on 2018/10/20.
 */
public enum Sex {
    NAME(0,"男"),
    FMAEL(1,"女");

    private int sexCode;
    private String sexName;

    public void setSexCode(int sexCode) {
        this.sexCode = sexCode;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    Sex(int sexCode, String sexName) {
        this.sexCode = sexCode;
        this.sexName = sexName;
    }

    public int getSexCode(){
        return sexCode;
    }

    public static Sex getSexFormCode(int code){
        for (Sex sex : Sex.values()){
            if (sex.getSexCode() == code){
                return sex;
            }
        }
        return null;
    }
}
