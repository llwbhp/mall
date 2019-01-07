package com.macro.mall.mapper;

import com.macro.mall.model.MemberBrandAttention;
import com.macro.mall.model.MemberBrandAttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberBrandAttentionMapper {
    int countByExample(MemberBrandAttentionExample example);

    int deleteByExample(MemberBrandAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberBrandAttention record);

    int insertSelective(MemberBrandAttention record);

    List<MemberBrandAttention> selectByExample(MemberBrandAttentionExample example);

    MemberBrandAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberBrandAttention record, @Param("example") MemberBrandAttentionExample example);

    int updateByExample(@Param("record") MemberBrandAttention record, @Param("example") MemberBrandAttentionExample example);

    int updateByPrimaryKeySelective(MemberBrandAttention record);

    int updateByPrimaryKey(MemberBrandAttention record);
}