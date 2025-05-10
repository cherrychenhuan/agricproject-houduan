package com.agric.myagric.utils;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import java.util.HashMap;
public class SmsUtil{
    public static String toSendMes(String phoneNumber,String code) {
        //1.连接阿里云
        /**
         "<your-region-id>",           // The region ID 地区标识
         "<your-access-key-id>",       // The AccessKey ID of the RAM account RAM账户的AccessKey ID 阿里云账号可查
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account RAM 账户的 AccessKey Secret 阿里云账号可查
         **/
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAI5tAXMca3azciYH9RnjG3", "l2gSzils3rV1jgJA9p1Rr8oa1CIG3f");
        IAcsClient client = new DefaultAcsClient(profile);
        //2.构建请求 自定义参数
        SendSmsRequest request = new SendSmsRequest();
        //接收短信的手机号码
        request.setPhoneNumbers(phoneNumber);
        //短信签名名称
        request.setSignName("农作物智能推荐平台");
        //短信模板CODE
        request.setTemplateCode("SMS_465355247");
        //模版内容:您正在使用阿里云短信测试服务，体验验证码是：${code}，如非本人操作，请忽略本短信！
        //短信模板变量对应的实际值
        //("{\"code\":\"1234\"}");
        HashMap<String,String> param=new HashMap<>();
        param.put("code",code);
        request.setTemplateParam(JSONObject.toJSONString(param));
        SendSmsResponse response = new SendSmsResponse();
        try {
            //3.发送请求
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        //短信成功返回json {  "RequestId": "614048FB-0619-4439-A1D5-AA8B218A****",  "Message": "OK",  "BizId": "386715418801811068^0",  "Code": "OK"}
        return response.getMessage();
    }
}
