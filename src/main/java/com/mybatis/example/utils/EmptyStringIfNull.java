package com.mybatis.example.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by huanglijun on 2018/10/19.
 */
public class EmptyStringIfNull implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getResult(ResultSet resultSet, String columnName) throws SQLException {
        System.out.println("之前： " + resultSet.getString(columnName));
        String result = (resultSet.getString(columnName) == null) ? "" : resultSet.getString(columnName);
        System.out.println("之后： " + resultSet.getString(columnName));
        return result;
    }

    @Override
    public String getResult(ResultSet resultSet, int columnName) throws SQLException {
        return (resultSet.getString(columnName) == null) ? "" : resultSet.getString(columnName);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
