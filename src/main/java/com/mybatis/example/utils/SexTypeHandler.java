package com.mybatis.example.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by huanglijun on 2018/10/20.
 */
public class SexTypeHandler implements TypeHandler<Sex> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sex.getSexCode());
    }

    @Override
    public Sex getResult(ResultSet resultSet, String s) throws SQLException {
        int result = resultSet.getInt(s);
        return Sex.getSexFormCode(result);
    }

    @Override
    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        int result = resultSet.getInt(i);
        return Sex.getSexFormCode(result);
    }

    @Override
    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        int result = callableStatement.getInt(i);
        return Sex.getSexFormCode(result);
    }
}
