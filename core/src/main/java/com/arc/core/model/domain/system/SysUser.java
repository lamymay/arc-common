package com.arc.core.model.domain.system;

import com.arc.core.model.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;
import java.util.List;
/**
 * 用户相关的服务
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_sys_user")
public class SysUser extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id

    private String nickname;// 用户昵称

    private String avatar;// 头像

    private Integer state;// 账号状态  天然false 不需要null的类型

    private Date createDate;// 创建时间

    private Date updateDate;// 更新时间


    private SysUserAuth auth;//一种登录方式

    private List<SysUserAuth> auths;//多种登录方式

    private List<SysRole> roles;

    public SysUser(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
