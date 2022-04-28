package com.shanjupay.merchant.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.catalina.manager.Constants.CHARSET;

@Slf4j
@Controller
//@RestController//请求方法响应统一json格式
public class PayTestController {

    //应用id
    String APP_ID = "2021000119678947";
    //应用私钥
    String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCpYOpD+E29h7Ea7HObwUBSffDSNahZhbUkqDHkWZEeIcRsZw/1wyA8MiwgRgEpvhXoguRbVwWvfkv4p7fGhln6GkQWuWz9uNBOX4wv5FtWbHIKRIGAA0BclUP6RjoPvL17VKhWCwv4bygQsirPeiG4LxoJCNetyjqn6gnZDI/SArFykDLtYUPAKHDSmAwfqLI+Sho4wslU38U52elRqmZPEISVfhnHBfLPTWxUIqPfGmqsnIwsbTg+TD3GE4rDIKwLX09qYQKJWghTGvW3AsUZiIMoMusZF5Y6CJ3RMhW0BwqP/Qfp98H0VDFz0EqoI6bnc27lS/9pNMwtM0+T/5E9AgMBAAECgf9Ss/+vMI7E/Hx9qPbKFpJRtSzhd1G8ZI0OWRIDbbht/g7q32frmFslCVqCZ6wptab84OyfrN4Z0pFF2J7jULaeaDTW47NUL+mGWyEYQWhXypvkZ47T8sJ6cme+zIuNI5thnPSVDs/Jfn0Rqe09YWUVieosfyTQtu3tD1m/oWKYJ+qWmSOg7A4sMNmF1+mlaDd8EfL3BXDYLeCfrVILWWsoc4RcnG3jmT+kVMXqg2gf2qlkarrVYNgn+tkkeo9D8nhZcuS+HAenfyrLckBQsWL3ndgVyAAuG5yzN4bJ41nO9g6HrG254o7zgeIfbfZvsnXQPgGeiRdyoDluTBf4YyECgYEA8+gpnhZ6NUWZLn0zLJWmkuZJ0kbKp6fYirV/eQIlqWlx/sN9R4F66JIv71GMjsm2gkL1CgWa7zzC1CpD3FElvYrXHjX7dkYvfdwkPxZ6r8htDxEavyfbCFSyXnJbGZyM6veohIfSfBfFgVoMQ797r0aAvpHTjnjpxifc2UHrc9UCgYEAscbJcY8Y2xW0E9DnDaP6Nhfs9fQT+P2tr6gU68Lh/3EmWzH/M40qgIe0MLpR1lZkWIxPMcRLxuMtPlmbCyESAFOkXd5f3qqJHVLkL/KQ4tATpdpr9sYBlnsw62QieaQmbnYRA5bAVpS+IX+GaXzPF1ngoDnI58HEhu291gddo8kCgYEA6Xe1PomteQih1AorzeWBiOO+jfUNTuYvNLb+ycnwWvWAFKjzZlreV3h3QdEBhjw24wFMpMcwwweaRpQeWOmkAoa/2z848MHF++eZGnpd/Z0QJ3fr7kYsNxE7m4RDB4T+rntZZ2LLa9UlTOfxDXhg4CnQWpojsyCyROcrUxryUfECgYEAhWlm91+qCY/qCgz1uFjchwfBfnpjGrJVS8NZn+wqaeZiIIIOwIMp6Dbu1Lqee7ltqL3zGKf1LhaCd44LOnjg53ndmcwuKg3UxDrWn9zrOito80hNSW4i9ukQNzZ4YMz9Qlw8PHM/eDo7zSvElRli2GVMmzGCQdo6P//ePOZeMXECgYEAr1ora97jU00aKB3GHkIY0e6f8kvS7wIQO3XJaQAJjeXhQCWmw+OWe3cZS1GER6WBCGCzBb8hF1UULPqkBTP3vOjk6RP1MBvlAmwPWWFfcFoZYjQKY6CEC4qTXRsErmSa5I+OWFA4YulfqU96OAOyvmXlKKwS1Nu4rSaJ8fPVo84=";
    //支付宝公钥
    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkdKmcmg++2toaZZWhE1Gh9vwRGlgay7AOjIgS9a9gcfMxcNJA/1whizgIDrKAxw4dSahavAm+HGsH2t4Xkj1x7TACMRYxk3kFsy3EGnPt48fzYQvZS8BRd3Ad3ihxdjGJWFcuFa1tKQzVfVFKqbZMb4w/Y6jvnwfX/d3NX1Ty6SSKM+xI54lRArgikpdRNIOekc4OadXiPt5odAf2zXS0abEQ6OwmMamy/orch5+ZGuJz4T1e7wqsHsT6r3DhC0++XSNpmisPDEz23UQPgsgLMnbNeutiyAylI+x30AcFx7UYDqI5gnsym0stgrtT7TkwxO2rRrb1pUEk0lJqtappwIDAQAB";
    String CHARSET = "utf-8";
    //支付宝接口的网关地址，正式"https://openapi.alipay.com/gateway.do"
    String serverUrl = "https://openapi.alipaydev.com/gateway.do";
    //签名算法类型
    String sign_type = "RSA2";

    @GetMapping("/alipaytest")
    public void alipaytest(HttpServletRequest httpRequest,
                           HttpServletResponse httpResponse) throws ServletException, IOException {
        //构造sdk的客户端对象
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, sign_type); //获得初始化的AlipayClient
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
//        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
//        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"20150420010101017\"," +
                " \"total_amount\":\"88.88\"," +
                " \"subject\":\"Iphone6 16G\"," +
                " \"product_code\":\"QUICK_WAP_PAY\"" +
                " }");//填充业务参数
        String form="";
        try {
            //请求支付宝下单接口,发起http请求
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

}
