package com.shanjupay.merchant.controller;

import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.shanjupay.merchant.api.service.MerchantService;
import com.shanjupay.merchant.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "aaa")
public class MerchantController {
    @Reference
    MerchantService merchantService;

    @Autowired
    SmsService smsService;

    @ApiOperation(value = "test")
    @GetMapping("/merchant/{id}")
    public MerchantDTO findBId(@PathVariable("id") Long id){
        MerchantDTO service = merchantService.findById(id);
        return service;
    }

    @ApiOperation("获取验证码")
    @GetMapping("/sms")
    @ApiImplicitParam(value = "手机号",name = "phnoe",required = true)
    public String getSMSCode(@RequestParam("phone") String phone){
        return smsService.sendMsg(phone);
    }
}
