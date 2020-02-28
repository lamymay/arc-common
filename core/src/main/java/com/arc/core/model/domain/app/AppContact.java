package com.arc.core.model.domain.app;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author 叶超
 * @since 2020/2/27 10:46
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppContact {

    private static final long serialVersionUID = 1L;

    //本系统中的id是主键
    private Integer id;

    //是每个通讯录中的id，不唯一，每个设备上的通讯录id各自独立
    private Integer contactId;

    //本系统唯一的用户id
    private Long userId;

    private String displayName;

    private String cellphone;
    private String telephone;
    private String email;

    private String im;
    private String photo;
    private String nickname;
    private String organization;
    private String postalAddress;
    private String groupMembership;

    //保留字段
    private String name;
    private Integer state;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
