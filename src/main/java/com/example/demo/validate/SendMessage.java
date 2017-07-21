package com.example.demo.validate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by clb on 17-3-20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessage {
	/**
	 * 短信平台提供的接口url
	 */
	@Pattern(regexp = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?",message = "url 格式错误")
	String url;
	/**
	 * 账户
	 */
	@NotNull
	String account;
	/**
	 * 密码
	 */
	@NotNull
	String password;
	/**
	 * 要发送的手机号
	 */
	@Pattern(regexp = "^1\\d{10}(,1\\d{10})*$",message = "手机号格式错误")
	String mobileNumber;
	/**
	 * 短信内容
	 */
	@NotNull
	String message;
	/**
	 * 前缀
	 */
	@NotNull
	String preInfo;

	@Override
	public String toString() {
		return "{" +
				"url='" + url + '\'' +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", message='" + message + '\'' +
				", preInfo='" + preInfo + '\'' +
				'}';
	}
}
