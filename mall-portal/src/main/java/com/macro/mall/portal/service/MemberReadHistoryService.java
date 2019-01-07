package com.macro.mall.portal.service;

import java.util.List;

import com.macro.mall.model.MemberReadHistory;

/**
 * 会员浏览记录管理Service Created by macro on 2018/8/3.
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<Long> ids, Long memberId);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
