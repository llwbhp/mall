package com.macro.mall.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.mapper.MemberBrandAttentionMapper;
import com.macro.mall.model.MemberBrandAttention;
import com.macro.mall.model.MemberBrandAttentionExample;
import com.macro.mall.portal.service.MemberAttentionService;

/**
 * 会员关注Service实现类 Created by macro on 2018/8/2.
 */
@Service
public class MemberAttentionServiceImpl implements MemberAttentionService {
    @Autowired
    private MemberBrandAttentionMapper memberBrandAttentionMapper;

    @Override
    public int add(MemberBrandAttention memberBrandAttention) {
        MemberBrandAttentionExample memberBrandAttentionExample = new MemberBrandAttentionExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberBrandAttention.getMemberId())
                .andBrandIdEqualTo(memberBrandAttention.getBrandId());
        int exist = memberBrandAttentionMapper.countByExample(memberBrandAttentionExample);
        if (exist <= 0) {
            memberBrandAttentionMapper.insert(memberBrandAttention);
        }
        return exist;
    }

    @Override
    public int delete(Long memberId, Long brandId) {
        MemberBrandAttentionExample memberBrandAttentionExample = new MemberBrandAttentionExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberId).andBrandIdEqualTo(brandId);
        return memberBrandAttentionMapper.deleteByExample(memberBrandAttentionExample);
    }

    @Override
    public List<MemberBrandAttention> list(Long memberId) {
        MemberBrandAttentionExample memberBrandAttentionExample = new MemberBrandAttentionExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberId);
        return memberBrandAttentionMapper.selectByExample(memberBrandAttentionExample);
    }
}
