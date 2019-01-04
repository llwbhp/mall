package com.macro.mall.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.OmsOrderReturnApplyParam;
import com.macro.mall.portal.service.OmsPortalOrderReturnApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 申请退货管理Controller Created by macro on 2018/10/17.
 */
@Controller
@Api(tags = "OmsPortalOrderReturnApplyController", description = "申请退货管理")
@RequestMapping("/returnapply")
public class OmsPortalOrderReturnApplyController {
    @Autowired
    private OmsPortalOrderReturnApplyService returnApplyService;

    @ApiOperation("申请退货")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult create(@RequestBody OmsOrderReturnApplyParam returnApply) {
        Integer count = returnApplyService.create(returnApply);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }
}
