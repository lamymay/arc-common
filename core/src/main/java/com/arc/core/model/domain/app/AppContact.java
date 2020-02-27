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


    /**
     * APP联系人表
     */
    private String cellphone;


    /**
     * APP联系人表
     */
    private String displayName;

    /**
     * APP联系人表
     */
    private String email;

    /**
     * APP联系人表
     */
    private String groupMembership;

    /**
     * APP联系人表
     */
    private Integer id;

    /**
     * APP联系人表
     */
    private String im;

    /**
     * 图片
     */
    private String photo;

    /**
     * APP联系人表
     */
    private String name;

    /**
     * APP联系人表
     */
    private String nickname;

    /**
     * APP联系人表
     */
    private String organization;

//    /**
//     *  APP联系人表
//     */
//    private Object photo;

    /**
     * APP联系人表
     */
    private String postalAddress;

    /**
     * APP联系人表
     */
    private Integer state;

    /**
     * APP联系人表
     */
    private String telephone;

    /**
     * APP联系人表
     */
    private LocalDateTime updateTime;

    /**
     * APP联系人表
     */
    private LocalDateTime createTime;
}
