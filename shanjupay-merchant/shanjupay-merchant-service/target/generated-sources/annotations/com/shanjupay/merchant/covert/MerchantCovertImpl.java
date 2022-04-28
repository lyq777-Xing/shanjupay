package com.shanjupay.merchant.covert;

import com.shanjupay.merchant.api.dto.MerchantDTO;
import com.shanjupay.merchant.entity.Merchant;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T14:17:33+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_302 (Amazon.com Inc.)"
)
public class MerchantCovertImpl implements MerchantCovert {

    @Override
    public MerchantDTO entity2dto(Merchant entity) {
        if ( entity == null ) {
            return null;
        }

        MerchantDTO merchantDTO = new MerchantDTO();

        merchantDTO.setId( entity.getId() );
        merchantDTO.setMerchantName( entity.getMerchantName() );
        merchantDTO.setMerchantNo( entity.getMerchantNo() );
        merchantDTO.setMerchantAddress( entity.getMerchantAddress() );
        merchantDTO.setMerchantType( entity.getMerchantType() );
        merchantDTO.setBusinessLicensesImg( entity.getBusinessLicensesImg() );
        merchantDTO.setIdCardFrontImg( entity.getIdCardFrontImg() );
        merchantDTO.setIdCardAfterImg( entity.getIdCardAfterImg() );
        merchantDTO.setUsername( entity.getUsername() );
        merchantDTO.setMobile( entity.getMobile() );
        merchantDTO.setContactsAddress( entity.getContactsAddress() );
        merchantDTO.setAuditStatus( entity.getAuditStatus() );
        merchantDTO.setTenantId( entity.getTenantId() );

        return merchantDTO;
    }

    @Override
    public Merchant dto2entity(MerchantDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Merchant merchant = new Merchant();

        merchant.setId( dto.getId() );
        merchant.setMerchantName( dto.getMerchantName() );
        merchant.setMerchantNo( dto.getMerchantNo() );
        merchant.setMerchantAddress( dto.getMerchantAddress() );
        merchant.setMerchantType( dto.getMerchantType() );
        merchant.setBusinessLicensesImg( dto.getBusinessLicensesImg() );
        merchant.setIdCardFrontImg( dto.getIdCardFrontImg() );
        merchant.setIdCardAfterImg( dto.getIdCardAfterImg() );
        merchant.setUsername( dto.getUsername() );
        merchant.setMobile( dto.getMobile() );
        merchant.setContactsAddress( dto.getContactsAddress() );
        merchant.setAuditStatus( dto.getAuditStatus() );
        merchant.setTenantId( dto.getTenantId() );

        return merchant;
    }
}
