package com.arc.core.model.response.app;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * APP联系人表Response
 *
 * @author lamy
 * @since
 */
@Getter
@Setter
public class AppContactResponse {

    private static final long serialVersionUID = 1L;

    private String cellphone;
    private String displayName;
    private String email;
    private String groupMembership;
    private Integer id;
    private String im;
    private String name;
    private String nickname;
    private String organization;
    private Object photo;
    private String postalAddress;
    private Integer state;
    private String telephone;

    private Date updateTime;
    private LocalDateTime createTime;
}
