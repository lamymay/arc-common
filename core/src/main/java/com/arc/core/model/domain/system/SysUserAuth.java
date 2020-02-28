package com.arc.core.model.domain.system;

import com.arc.core.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户授权信息表
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SysUserAuth extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;//用户授权信息表ID

    private Long userId;//用户的id

    private String identifier;// 标识（手机号 邮箱 用户名或第三方应用的唯一标识） 1=username/password 2=cellphone 3=email 4=wechat 5=weibo 6=qq

    private String credential;// 密码凭证（站内的保存密码，站外的不保存或保存token）

    private int identityType;// 登录类型（1用户名 2手机号3 邮箱 4微信 5微博等）

    private Integer state;// 状态(逻辑删除/停用)

    private Integer verified;// 验证与否

    private Date createDate;// 创建时间

    private Date updateDate;// 更新时间

    public SysUserAuth(String identifier, String credential, int identityType) {
        super();
        this.identifier = identifier;
        this.credential = credential;
        this.identityType = identityType;
    }

    public SysUserAuth(String identifier, String credential) {
        super();
        this.identifier = identifier;
        this.credential = credential;
        this.identityType = 0;
    }

//    private SysUser user;

}
