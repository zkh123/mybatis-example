package com.mybatis.example.dao;

import com.mybatis.example.entity.PingTB;
import com.mybatis.example.model.PingModel;
import com.mybatis.example.vo.PingTBVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by huanglijun on 2018/10/18.
 */
public interface PingTBMapper {

    List<PingTB> selectPingById(@Param(value = "id")int id);

    List<PingTB> selectPingByBizId(@Param(value = "BizId")int BizId);

    List<Map<String,Object>> selectPingByBizId2(@Param(value = "BizId")int BizId);

    List<Map<String,Object>> selectPingByBizId3(@Param(value = "BizId")int BizId);

    List<PingTB> selectPingByBizId4(@Param(value = "BizId")int BizId);

    Integer insertOne(PingTB pingTB);

    Integer batchInsert(List<PingTB> list);

    Integer updateById(PingTB pingTB);

    List<PingTB> batchSelect(@Param(value = "ids")List<Integer> listId);

    Integer deleteById(@Param(value = "id")int id);

    Integer batchDelete(@Param(value = "array")int[] ids);

    List<PingTB> findPingList(@Param(value = "pingTBVo") PingTBVo pingTBVo);

    List<PingTB> selectPingByBizId5(@Param(value = "BizId")int BizId);

    PingModel selectPingById1(@Param(value = "id")int id);

}
