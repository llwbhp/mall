package com.macro.mall.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.mapper.MemberProductCollectionMapper;
import com.macro.mall.model.MemberProductCollection;
import com.macro.mall.model.MemberProductCollectionExample;
import com.macro.mall.portal.service.MemberCollectionService;

/**
 * 会员收藏Service实现类 Created by macro on 2018/8/2.
 */
@Service
public class MemberCollectionServiceImpl implements MemberCollectionService {
    @Autowired
    private MemberProductCollectionMapper memberProductCollectionMapper;

    @Override
    public int addProduct(MemberProductCollection productCollection) {

        MemberProductCollectionExample memberBrandAttentionExample = new MemberProductCollectionExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(productCollection.getMemberId())
                .andProductIdEqualTo(productCollection.getProductId());
        int exist = memberProductCollectionMapper.countByExample(memberBrandAttentionExample);
        if (exist <= 0) {
            memberProductCollectionMapper.insert(productCollection);
        }
        return exist;
    }

    @Override
    public int deleteProduct(Long memberId, Long productId) {
        MemberProductCollectionExample memberBrandAttentionExample = new MemberProductCollectionExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberId).andProductIdEqualTo(productId);
        return memberProductCollectionMapper.deleteByExample(memberBrandAttentionExample);
    }

    @Override
    public List<MemberProductCollection> listProduct(Long memberId) {
        MemberProductCollectionExample memberBrandAttentionExample = new MemberProductCollectionExample();
        memberBrandAttentionExample.createCriteria().andMemberIdEqualTo(memberId);
        return memberProductCollectionMapper.selectByExample(memberBrandAttentionExample);
    }
}
