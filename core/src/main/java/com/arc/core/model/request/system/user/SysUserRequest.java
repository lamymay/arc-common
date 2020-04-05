package com.arc.core.model.request.system.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author may
 * @since 2019/12/29 17:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRequest {

    @NotNull(message = "昵称不能为空")
    private String nickname;// 用户昵称

//    private String avatar;// 头像

    @NotNull(message = "状态不能为空")
    private Integer state;// 账号状态  天然false 不需要null的类型
}
