package com.macro.mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.MemberReadHistory;
import com.macro.mall.portal.service.MemberReadHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员商品浏览记录管理Controller Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory) {
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count > 0) {
            return new CommonResult(count);
        } else {
            return CommonResult.buildErrorResponse();
        }
    }

    @ApiOperation("删除浏览记录")
    @PostMapping(value = "/delete")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        int count = memberReadHistoryService.delete(ids);
        if (count > 0) {
            return new CommonResult(count);
        } else {
            return CommonResult.buildErrorResponse();
        }
    }

    @ApiOperation("展示浏览记录")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult list(Long memberId) {
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return new CommonResult(memberReadHistoryList);
    }
}
