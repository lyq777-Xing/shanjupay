package com.shanjupay.merchant.api.service;

import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2022-04-26
 */
public interface MerchantService{
    MerchantDTO findById(Long id);
}
