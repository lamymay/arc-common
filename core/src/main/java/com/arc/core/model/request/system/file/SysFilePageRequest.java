package com.arc.core.model.request.system.file;

import com.arc.core.model.request.PageQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 分页查询参数
 *
 * @author lamymay
 */
@Getter
@Setter
@ToString
public class SysFilePageRequest extends PageQuery {

    private static final long serialVersionUID = 1L;

    private Long id;//自增主键
    private String name;// 显示名称
    private String suffix;// 后缀
    private Integer version;// 版本信息id
    private String code;// 版本号
    private String key;// 文件标识
    private Long size;// 文件大小
    private String url;// 文件存放url
    private String note;// 描述
    private String checkType;// 校验方式
    private String checkCode;// 校验码
    private Integer state;// 逻辑删除用的标识
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间


}
