package com.arc.model.domain.blog;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文章标签表，多对多
 */
@Getter
@Setter
@ToString
public class BlogTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;// 文章自增ID
    private String tagName;// 标签名称
}
