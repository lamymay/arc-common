package com.arc.zero.model.response.wechat;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统用户表
 *
 * @author lamy
 * @since 2020-01-12 11:40:45
 */
@Getter
@Setter
public class WeChatAccessTokenResponse {

	private static final long serialVersionUID = 1L;

	private String accessToken;// 解析后的 accessToken,注意是否过期(后期引入redis后将直接使用redis存储而非db接使用redis存储而非db)
	private String corpId;// corpid 每一个企业有唯一的一个企业id
	private String corpSecret;// corpsecret 每一个应用有唯一的一个应用的id以及应用的密钥  注意是可以被刷新的
	private Date createTime;// 创建时间
	private Long expiresIn;// 过期时间，单位ms
	private Long id;// 自增id
	private String remark;// 注释
	private String response;// 微信服务器返回数据
	private Integer state;// 状态
	private Date updateTime;// 更新时间
	private Integer version;// 乐观锁控制
}
