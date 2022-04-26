package com.shanjupay.merchant.controller;

import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.shanjupay.merchant.api.service.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "aaa")
public class MerchantController {
    @Reference
    MerchantService merchantService;

    @ApiOperation(value = "bbb")
    @GetMapping("/merchant/{id}")
    public MerchantDTO findBId(@PathVariable("id") Long id){
        MerchantDTO service = merchantService.findById(id);
        return service;
    }
}
