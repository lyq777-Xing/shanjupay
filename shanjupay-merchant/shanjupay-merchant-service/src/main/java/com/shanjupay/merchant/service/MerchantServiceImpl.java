package com.shanjupay.merchant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.shanjupay.merchant.api.service.MerchantService;
import com.shanjupay.merchant.covert.MerchantCovert;
import com.shanjupay.merchant.entity.Merchant;
import com.shanjupay.merchant.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator.
 */
@org.apache.dubbo.config.annotation.Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantMapper merchantMapper;

//    @Autowired
//    MerchantCovert merchantCovert;

    @Override
    public MerchantDTO findById(Long id) {
        Merchant merchant = merchantMapper.selectById(id);
//        MerchantDTO merchantDTO = new MerchantDTO();
//        merchantDTO.setId(merchant.getId());
//        merchantDTO.setMerchantName(merchant.getMerchantName());
//        merchantDTO.setMerchantAddress(merchantDTO.getMerchantAddress());
//        实现对象转换
        MerchantDTO merchantDTO = MerchantCovert.INSTANCE.entity2dto(merchant);
        return merchantDTO;
    }
}
