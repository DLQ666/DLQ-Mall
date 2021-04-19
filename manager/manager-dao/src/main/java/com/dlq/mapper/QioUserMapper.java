package com.dlq.mapper;


import com.dlq.pojo.QioUser;
import com.dlq.pojo.QioUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QioUserMapper {
    int countByExample(QioUserExample example);

    int deleteByExample(QioUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QioUser record);

    int insertSelective(QioUser record);

    List<QioUser> selectByExample(QioUserExample example);

    QioUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QioUser record, @Param("example") QioUserExample example);

    int updateByExample(@Param("record") QioUser record, @Param("example") QioUserExample example);

    int updateByPrimaryKeySelective(QioUser record);

    int updateByPrimaryKey(QioUser record);
}
