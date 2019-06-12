package com.arc.model.domain.system;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
//@Validated
//@Entity
//@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long id; //主键

	private String nickname; // 昵称

	private String avatar; // 化身头像路径

	private Integer level; // 级别(权限控制中用)

	private Integer gender; // 性别｛0未知/1男/2女｝

	private Date birthday; // 出生日期

	private String sign; // 个性签名

	private Integer userType; // 用户类型

    private Area area;

    private List<Area> areas;

    //"message": "JSON parse error: Cannot deserialize value of type `java.util.Date` from String \"2018-09-10 23:15\": not a valid representation (error: Failed to parse Date value '2018-09-10 23:15': Cannot parse date \"2018-09-10 23:15\": while it seems to fit format 'yyyy-MM-dd'T'HH:mm:ss.SSSZ', parsing fails (leniency? null)); nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.util.Date` from String \"2018-09-10 23:15\": not a valid representation (error: Failed to parse Date value '2018-09-10 23:15': Cannot parse date \"2018-09-10 23:15\": while it seems to fit format 'yyyy-MM-dd'T'HH:mm:ss.SSSZ', parsing fails (leniency? null))\n at [Source: (PushbackInputStream); line: 8, column: 13] (through reference chain: com.arc.model.domain.system.User[\"birthday\"])",
}
