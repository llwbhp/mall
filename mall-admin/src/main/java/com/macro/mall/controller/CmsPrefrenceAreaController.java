package com.macro.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.dto.CommonResult;
import com.macro.mall.model.CmsPrefrenceArea;
import com.macro.mall.service.CmsPrefrenceAreaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商品优选管理Controller Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping(value = "/listAll")
    @ResponseBody
    public Object listAll() {
        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        return new CommonResult().success(prefrenceAreaList);
    }
}
