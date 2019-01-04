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

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.MemberProductCollection;
import com.macro.mall.portal.service.MemberCollectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员收藏管理Controller Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "MemberCollectionController", description = "会员收藏管理")
@RequestMapping("/member/collection")
public class MemberCollectionController {
    @Autowired
    private MemberCollectionService memberCollectionService;

    @ApiOperation("添加商品收藏")
    @PostMapping(value = "/addproduct")
    @ResponseBody
    public CommonResult addProduct(@RequestBody MemberProductCollection productCollection) {
        int count = memberCollectionService.addProduct(productCollection);
        if (count > 0) {
            return new CommonResult(count);
        } else {
            return CommonResult.buildErrorResponse();
        }
    }

    @ApiOperation("删除收藏商品")
    @PostMapping(value = "/deleteproduct")
    @ResponseBody
    public CommonResult deleteProduct(Long memberId, Long productId) {
        int count = memberCollectionService.deleteProduct(memberId, productId);
        if (count > 0) {
            return new CommonResult(count);
        } else {
            return CommonResult.buildErrorResponse();
        }
    }

    @ApiOperation("显示关注列表")
    @GetMapping(value = "/listproduct/{memberId}")
    @ResponseBody
    public CommonResult listProduct(@PathVariable Long memberId) {
        List<MemberProductCollection> memberProductCollectionList = memberCollectionService.listProduct(memberId);
        return new CommonResult(memberProductCollectionList);
    }
}
