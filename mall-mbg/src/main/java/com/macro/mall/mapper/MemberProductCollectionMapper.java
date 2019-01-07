package com.macro.mall.mapper;

import com.macro.mall.model.MemberProductCollection;
import com.macro.mall.model.MemberProductCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberProductCollectionMapper {
    int countByExample(MemberProductCollectionExample example);

    int deleteByExample(MemberProductCollectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberProductCollection record);

    int insertSelective(MemberProductCollection record);

    List<MemberProductCollection> selectByExample(MemberProductCollectionExample example);

    MemberProductCollection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberProductCollection record, @Param("example") MemberProductCollectionExample example);

    int updateByExample(@Param("record") MemberProductCollection record, @Param("example") MemberProductCollectionExample example);

    int updateByPrimaryKeySelective(MemberProductCollection record);

    int updateByPrimaryKey(MemberProductCollection record);
}