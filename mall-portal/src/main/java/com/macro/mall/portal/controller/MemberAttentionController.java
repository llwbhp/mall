package com.macro.mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.model.MemberBrandAttention;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.service.MemberAttentionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员关注品牌管理Controller Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "MemberAttentionController", description = "会员关注品牌管理")
@RequestMapping("/member/attention")
public class MemberAttentionController {
    @Autowired
    private MemberAttentionService memberAttentionService;

    @ApiOperation("添加品牌关注")
    @PostMapping(value = "/add")
    @ResponseBody
    public CommonResult add(@RequestBody MemberBrandAttention memberBrandAttention) {
        int count = memberAttentionService.add(memberBrandAttention);
        if (count > 0) {
            return new CommonResult(count);
        } else {
            return CommonResult.buildErrorResponse();
        }
    }

    @ApiOperation("取消关注")
    @PostMapping(value = "/delete")
    @ResponseBody
    public CommonResult delete(Long memberId, Long brandId) {
        int count = memberAttentionService.delete(memberId, brandId);
        if (count > 0) {
            return new CommonResult(count);
        } else {
            return CommonResult.buildErrorResponse();
        }
    }

    @ApiOperation("显示关注列表")
    @GetMapping(value = "/list/{memberId}")
    @ResponseBody
    public CommonResult list(@PathVariable Long memberId) {
        List<MemberBrandAttention> memberBrandAttentionList = memberAttentionService.list(memberId);
        return new CommonResult(memberBrandAttentionList);
    }
}
