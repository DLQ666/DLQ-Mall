package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioItemDesc;
import com.dlq.pojo.QioItemDescExample;
import org.apache.ibatis.annotations.Param;

public interface QioItemDescMapper {
    int countByExample(QioItemDescExample example);

    int deleteByExample(QioItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(QioItemDesc record);

    int insertSelective(QioItemDesc record);

    List<QioItemDesc> selectByExampleWithBLOBs(QioItemDescExample example);

    List<QioItemDesc> selectByExample(QioItemDescExample example);

    QioItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") QioItemDesc record, @Param("example") QioItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") QioItemDesc record, @Param("example") QioItemDescExample example);

    int updateByExample(@Param("record") QioItemDesc record, @Param("example") QioItemDescExample example);

    int updateByPrimaryKeySelective(QioItemDesc record);

    int updateByPrimaryKeyWithBLOBs(QioItemDesc record);
}
