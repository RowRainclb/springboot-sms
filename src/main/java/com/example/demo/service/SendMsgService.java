package com.example.demo.service;

import com.example.demo.validate.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信
 *
 * @author create by clb 2017-03-16
 */
@Service
public class SendMsgService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * <p>send message to the mobile number</p>
     * @param url   the url
     * @param account the account is need if you send message, you can ask your Administrator
     * @param pswd  the password is need if you send message, you can ask your Administrator
     * @param mobile the mobile phone
     * @param msg   the content of message
     * @exception Exception
     */
    public String send(String url,String account,String pswd,String mobile,String msg,String preInfo) throws Exception{
        String infoError = "";
        try{
            msg = "【"+preInfo+"】"+msg;
            Map<String,String> info=new HashMap<>();
            info.put("un",account);
            info.put("pw",pswd);
            info.put("phone",mobile);
            info.put("msg",msg);
            info.put("rd", "1");//是否需要状态报告，需要1，不需要0
            url = url +"?un={un}&pw={pw}&phone={phone}&msg={msg}&rd={rd}";
            infoError = restTemplate.getForObject(url,String.class, info);
        }catch (Exception e){
            throw new Exception("发送短信接口错误,检查用户名和密码是否正确",e);

         }
        return infoError;
    }

    /**
     * <p>send message to the mobile number</p>
     * @param sendMessage   发送短信的类对象
     * @exception Exception
     */
    public String send(SendMessage sendMessage) throws Exception{
            String infoError = "";
        try{
            String msg = "【"+sendMessage.getPreInfo()+"】"+sendMessage.getMessage();
            Map<String,String> info=new HashMap<>();
            info.put("un",sendMessage.getAccount());
            info.put("pw",sendMessage.getPassword());
            info.put("phone",sendMessage.getMobileNumber());
            info.put("msg",msg);
            info.put("rd", "1");//是否需要状态报告，需要1，不需要0
            String url = sendMessage.getUrl()+"?un={un}&pw={pw}&phone={phone}&msg={msg}&rd={rd}";
            infoError = restTemplate.getForObject(url,String.class, info);
        }catch(Exception e){
            throw new Exception("发送短信接口错误,检查用户名和密码是否正确",e);
        }
        return infoError;
    }

}
