package com.shanjupay.merchant.service;

public interface SmsService {
    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    String sendMsg(String phone);
}
