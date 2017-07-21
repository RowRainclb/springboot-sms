package com.example.demo.service;

import com.example.demo.validate.SendMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
/** 
* SendMsgService Tester. 
* 
* @author <clb> 
* @since <pre>七月 21, 2017</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@Rollback
@SpringBootTest
public class SendMsgServiceTest { 

    @Autowired
    private SendMsgService testObject;
    
    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
        /** 
    * 
    * Method: send(String url, String account, String pswd, String mobile, String msg, String preInfo) 
    * 
    */ 
    @Test
    public void testSendForUrlAccountPswdMobileMsgPreInfo() throws Exception { 
    //TODO: Test goes here... 
    } 
    
        /** 
    * 
    * Method: send(SendMessage sendMessage) 
    * 
    */ 
    @Test
    public void testSendSendMessage() throws Exception {
        String url = "http://sms.253.com/msg/send";// 应用地址
        String account = "N2537691";
        String password = "emv8qxQM4X2cf7";
        String mobileNumber = "18010179602";// 手机号码，多个号码使用","分割
        String preInfo = "253云通讯";
        String message = "测试短信";
        String product = "1";// 是否需要状态报告，需要1，不需要0
//		String extno = null;// 扩展码
        SendMessage sendMessage = new SendMessage(url,account,password,mobileNumber,message,preInfo);
        testObject.send(sendMessage);
    } 
    
        
    } 
