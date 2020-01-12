package com.arc.zero.model.domain.wechat;

import lombok.*;

import java.util.Date;

//import javax.persistence.*;


/**
 * 企业微信accessToken相关的数据实体
 * 后期引入redis后将直接使用redis存储而非MySQL
 *
 * @author 叶超
 * @description 客户实体
 * @since 2019/9/25 13:58
 */
@Setter
@Getter
@ToString
//@Entity
//@Table(name = "t_sys_wechat_access_token")
public class WeChatAccessToken {

    private static final long serialVersionUID = 1L;


    /**
     * 自增 主键id
     */
    private Long id;

    /**
     * 解析后的 accessToken,注意是否过期
     * (后期引入redis后将直接使用redis存储而非db接使用redis存储而非db)
     */
    private String accessToken;

    /**
     * corpid 每一个企业有唯一的一个企业id
     */
    private String corpId;

    /**
     * corpsecret 每一个应用有唯一的一个应用的id以及应用的密钥  注意是可以被刷新的
     */
    private String corpSecret;


    /**
     * 过期时间，单位ms
     */
    private Long expiresIn;

    /**
     * 注释
     */
    private String remark;

    /**
     * 微信服务器返回数据
     */
    private String response;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 乐观锁控制
     */
    private Integer version;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
