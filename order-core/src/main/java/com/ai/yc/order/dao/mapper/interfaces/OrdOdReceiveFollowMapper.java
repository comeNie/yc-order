package com.ai.yc.order.dao.mapper.interfaces;

import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollow;
import com.ai.yc.order.dao.mapper.bo.OrdOdReceiveFollowCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOdReceiveFollowMapper {
    int countByExample(OrdOdReceiveFollowCriteria example);

    int deleteByExample(OrdOdReceiveFollowCriteria example);

    int deleteByPrimaryKey(Long receiveFollowId);

    int insert(OrdOdReceiveFollow record);

    int insertSelective(OrdOdReceiveFollow record);

    List<OrdOdReceiveFollow> selectByExample(OrdOdReceiveFollowCriteria example);

    OrdOdReceiveFollow selectByPrimaryKey(Long receiveFollowId);

    int updateByExampleSelective(@Param("record") OrdOdReceiveFollow record, @Param("example") OrdOdReceiveFollowCriteria example);

    int updateByExample(@Param("record") OrdOdReceiveFollow record, @Param("example") OrdOdReceiveFollowCriteria example);

    int updateByPrimaryKeySelective(OrdOdReceiveFollow record);

    int updateByPrimaryKey(OrdOdReceiveFollow record);
}