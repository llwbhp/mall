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

import com.macro.mall.model.UmsMemberReceiveAddress;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.service.UmsMemberReceiveAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员收货地址管理Controller Created by macro on 2018/8/28.
 */
@Controller
@Api(tags = "UmsMemberReceiveAddressController", description = "会员收货地址管理")
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController {
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;

    @ApiOperation("添加收货地址")
    @PostMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody UmsMemberReceiveAddress address) {
        int count = memberReceiveAddressService.add(address);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("删除收货地址")
    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable Long id) {
        int count = memberReceiveAddressService.delete(id);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("修改收货地址")
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    public Object update(@PathVariable Long id, @RequestBody UmsMemberReceiveAddress address) {
        int count = memberReceiveAddressService.update(id, address);
        if (count > 0) {
            return new CommonResult(count);
        }
        return CommonResult.buildErrorResponse();
    }

    @ApiOperation("显示所有收货地址")
    @GetMapping(value = "/list")
    @ResponseBody
    public Object list() {
        List<UmsMemberReceiveAddress> addressList = memberReceiveAddressService.list();
        return new CommonResult(addressList);
    }

    @ApiOperation("显示所有收货地址")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Object getItem(@PathVariable Long id) {
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(id);
        return new CommonResult(address);
    }
}
