package com.arc.core.model.domain.system;

import com.arc.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 系统文件记录
 */
@Getter
@Setter
@ToString
public class SysFile extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;//id
    private String code;//编号

    //文件 本身属性： 名称/大小/后缀/文件位置/类型
    private String name;// 显示名称
    private String lengthUnit;// 文件大小单位
    private Long length;// 文件大小

    private String suffix;// 后缀
    private String type;// 类型 文件还是图片  一般来说图片是可以直接预览的,

    private String note;// 描述

    private String path;// 文件本地存放位置--如果是自己的环境应该是服务器的绝对路径

    private String location;// 文件持久化位置，用于 判断拼接url前部分    SERVER / DEVELOP
    private String host;// 文件持久化位置，用于 判断拼接url前部分    SERVER / DEVELOP  或者偷懒直接写 ip
    private String uri;// 文件存放 url=      {host}:{port} +/xxx/yyy/zzz

    private String thumbnailUri;//缩略图 注意仅仅图片应该由此相数据 图片类型有此属性，缩略图地址，其磁盘路径与主图path相似，在文件名称中加入small标识，格式：123_small.png

    private Integer version;// 版本信息id
    private Integer state;// 逻辑删除用的标识

    private String key;// 文件标识
    private String checkType;// 校验方式
    private String checkCode;// 校验码

    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    public SysFile() {

    }

    public SysFile(Long id) {
        this.id = id;
    }

    public SysFile(String code) {
        this.code = code;
    }
/*

    public String getFormatLength() {
        if (null == this.getLengthUnit() || "".equals(this.getLengthUnit())) {
            return LengthUtil.formatFileLength(length);
        } else {

            return this.getLengthUnit();
        }
    }
*/

}

//URI = Universal Resource Identifier 统一资源标志符，用来标识抽象或物理资源的一个紧凑字符串。
//URL = Universal Resource Locator 统一资源定位符，一种定位资源的主要访问机制的字符串，一个标准的URL必须包括：protocol、host、port、path、parameter、anchor。
//URN = Universal Resource Name 统一资源名称，通过特定命名空间中的唯一名称或ID来标识资源。
//————————————————
//版权声明：本文为CSDN博主「koflance@西溪」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/koflance/article/details/79635240
