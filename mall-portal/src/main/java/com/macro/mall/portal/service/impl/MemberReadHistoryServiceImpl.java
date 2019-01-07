package com.macro.mall.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.mapper.MemberReadHistoryMapper;
import com.macro.mall.model.MemberReadHistory;
import com.macro.mall.model.MemberReadHistoryExample;
import com.macro.mall.portal.service.MemberReadHistoryService;

/**
 * 会员浏览记录管理Service实现类 Created by macro on 2018/8/3.
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryMapper memberReadHistoryMapper;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        MemberReadHistoryExample memberBrandAttentionExample = new MemberReadHistoryExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberReadHistory.getMemberId())
                .andProductIdEqualTo(memberReadHistory.getProductId());
        int exist = memberReadHistoryMapper.countByExample(memberBrandAttentionExample);
        if (exist <= 0) {
            memberReadHistoryMapper.insert(memberReadHistory);
        }
        return exist;
    }

    @Override
    public int delete(List<Long> ids, Long memberId) {

        MemberReadHistoryExample memberBrandAttentionExample = new MemberReadHistoryExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberId).andProductIdIn(ids);
        return memberReadHistoryMapper.deleteByExample(memberBrandAttentionExample);

    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        MemberReadHistoryExample memberBrandAttentionExample = new MemberReadHistoryExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberId);
        return memberReadHistoryMapper.selectByExample(memberBrandAttentionExample);
    }
}
