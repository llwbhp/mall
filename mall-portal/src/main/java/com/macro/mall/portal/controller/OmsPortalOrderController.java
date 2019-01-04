package com.macro.mall.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.service.OmsPortalOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单管理Controller Created by macro on 2018/8/30.
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成确认单信息")
    @PostMapping(value = "/generateconfirmorder")
    @ResponseBody
    public CommonResult generateConfirmOrder() {
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return new CommonResult(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping(value = "/generateOrder")
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }

    @ApiOperation("支付成功的回调")
    @PostMapping(value = "/paySuccess")
    @ResponseBody
    public Object paySuccess(@RequestParam Long orderId) {
        return portalOrderService.paySuccess(orderId);
    }

    @ApiOperation("自动取消超时订单")
    @PostMapping(value = "/cancelTimeOutOrder")
    @ResponseBody
    public Object cancelTimeOutOrder() {
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @PostMapping(value = "/cancelOrder")
    @ResponseBody
    public Object cancelOrder(Long orderId) {
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.buildSuccessResponseWithoutData();
    }
}
