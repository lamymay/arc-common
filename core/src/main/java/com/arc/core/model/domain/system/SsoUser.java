package com.arc.core.model.domain.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * SSO用户
 * @author yechao
 * @date 2018/09/28
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SsoUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;// user主键ID

    private String nickname;// 昵称

    private String avatar;// 化身

    private Integer sign;// 标记
}
