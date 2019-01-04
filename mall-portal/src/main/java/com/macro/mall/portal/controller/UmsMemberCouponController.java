package com.macro.mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.model.SmsCouponHistory;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.SmsCouponHistoryDetail;
import com.macro.mall.portal.service.OmsCartItemService;
import com.macro.mall.portal.service.UmsMemberCouponService;
import com.macro.mall.portal.service.UmsMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 用户优惠券管理Controller Created by macro on 2018/8/29.
 */
@Controller
@Api(tags = "UmsMemberCouponController", description = "用户优惠券管理")
@RequestMapping("/member/coupon")
public class UmsMemberCouponController {
    @Autowired
    private UmsMemberCouponService memberCouponService;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("领取指定优惠券")
    @PostMapping(value = "/add/{couponId}")
    @ResponseBody
    public CommonResult add(@PathVariable Long couponId) {
        return memberCouponService.add(couponId);
    }

    @ApiOperation("获取用户优惠券列表")
    @ApiImplicitParam(name = "useStatus", value = "优惠券筛选类型:0->未使用；1->已使用；2->已过期", allowableValues = "0,1,2", paramType = "query", dataType = "integer")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult list(@RequestParam(value = "useStatus", required = false) Integer useStatus) {
        List<SmsCouponHistory> couponHistoryList = memberCouponService.list(useStatus);
        return new CommonResult(couponHistoryList);
    }

    @ApiOperation("获取登录会员购物车的相关优惠券")
    @ApiImplicitParam(name = "type", value = "使用可用:0->不可用；1->可用", defaultValue = "1", allowableValues = "0,1", paramType = "query", dataType = "integer")
    @GetMapping(value = "/list/cart/{type}")
    @ResponseBody
    public CommonResult listCart(@PathVariable Integer type) {
        List<CartPromotionItem> cartPromotionItemList = cartItemService
                .listPromotion(memberService.getCurrentMember().getId());
        List<SmsCouponHistoryDetail> couponHistoryList = memberCouponService.listCart(cartPromotionItemList, type);
        return new CommonResult(couponHistoryList);
    }
}
