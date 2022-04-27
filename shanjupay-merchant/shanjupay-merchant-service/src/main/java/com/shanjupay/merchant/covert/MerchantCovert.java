package com.shanjupay.merchant.covert;

import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.shanjupay.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 实现对象祝你换
 */
@Mapper
public interface MerchantCovert {
    MerchantCovert INSTANCE = Mappers.getMapper(MerchantCovert.class);


    /**
     * 将entity转化为DTO
     * @param entity
     * @return
     */
    MerchantDTO entity2dto(Merchant entity);

    /**
     * 把DTO转化为entity
     * @param dto
     * @return
     */
    Merchant dto2entity(MerchantDTO dto);

    public static void main(String[] args) {
        //dto转entity
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setUsername("测试");
        merchantDTO.setPassword("111");
        Merchant entity = MerchantCovert.INSTANCE.dto2entity(merchantDTO);
        //entity转dto
        entity.setMobile("123444554");
        MerchantDTO merchantDTO1 = MerchantCovert.INSTANCE.entity2dto(entity);
        System.out.println(merchantDTO1);
    }
}
