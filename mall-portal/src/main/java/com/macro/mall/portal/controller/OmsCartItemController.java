package com.macro.mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartProduct;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.service.OmsCartItemService;
import com.macro.mall.portal.service.UmsMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 购物车管理Controller Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "OmsCartItemController", description = "购物车管理")
@RequestMapping("/cart")
public class OmsCartItemController {
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("添加商品到购物车")
    @PostMapping(value = "/add")
    @ResponseBody
    public CommonResult add(@RequestBody OmsCartItem cartItem) {
        int count = cartItemService.add(cartItem);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("获取某个会员的购物车列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult list() {
        List<OmsCartItem> cartItemList = cartItemService.list(memberService.getCurrentMember().getId());
        return new CommonResult(cartItemList);
    }

    @ApiOperation("获取某个会员的购物车列表,包括促销信息")
    @GetMapping(value = "/list/promotion")
    @ResponseBody
    public CommonResult listPromotion() {
        List<CartPromotionItem> cartPromotionItemList = cartItemService
                .listPromotion(memberService.getCurrentMember().getId());
        return new CommonResult(cartPromotionItemList);
    }

    @ApiOperation("修改购物车中某个商品的数量")
    @GetMapping(value = "/update/quantity")
    @ResponseBody
    public CommonResult updateQuantity(@RequestParam Long id, @RequestParam Integer quantity) {
        int count = cartItemService.updateQuantity(id, memberService.getCurrentMember().getId(), quantity);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("获取购物车中某个商品的规格,用于重选规格")
    @GetMapping(value = "/getproduct/{productId}")
    @ResponseBody
    public CommonResult getCartProduct(@PathVariable Long productId) {
        CartProduct cartProduct = cartItemService.getCartProduct(productId);
        return new CommonResult(cartProduct);
    }

    @ApiOperation("修改购物车中商品的规格")
    @PostMapping(value = "/update/attr")
    @ResponseBody
    public CommonResult updateAttr(@RequestBody OmsCartItem cartItem) {
        int count = cartItemService.updateAttr(cartItem);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("删除购物车中的某个商品")
    @PostMapping(value = "/delete")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = cartItemService.delete(memberService.getCurrentMember().getId(), ids);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("清空购物车")
    @PostMapping(value = "/clear")
    @ResponseBody
    public CommonResult clear() {
        int count = cartItemService.clear(memberService.getCurrentMember().getId());
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }
}
