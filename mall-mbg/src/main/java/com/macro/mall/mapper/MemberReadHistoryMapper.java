package com.macro.mall.mapper;

import com.macro.mall.model.MemberReadHistory;
import com.macro.mall.model.MemberReadHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberReadHistoryMapper {
    int countByExample(MemberReadHistoryExample example);

    int deleteByExample(MemberReadHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberReadHistory record);

    int insertSelective(MemberReadHistory record);

    List<MemberReadHistory> selectByExample(MemberReadHistoryExample example);

    MemberReadHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberReadHistory record, @Param("example") MemberReadHistoryExample example);

    int updateByExample(@Param("record") MemberReadHistory record, @Param("example") MemberReadHistoryExample example);

    int updateByPrimaryKeySelective(MemberReadHistory record);

    int updateByPrimaryKey(MemberReadHistory record);
}