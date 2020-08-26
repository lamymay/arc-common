package com.arc.core.model.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志表
 */
@Getter
@Setter
@ToString
@TableName("t_sys_log")
public class Log extends Model<Log> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 日志主键

    private Date createDate;// 记录创建时间
    private String fromAddress;// 操作者的地址
    private Integer insertQuantity;// 插入数量
    private String method;// 方法/动作
    private String name;// 操作名称
    private String note;// 操作备注
    private Long operatorId;// 操作者id
    private String operatorName;// 操作者名称
    private String parameter;// 参数
    private Integer success;// 状态码成功与否
    private Integer successQuantity;// 成功数量  successQuantity=updateQuantity+saveQuantity
    private String targetAddress;// 操作资源的目标地址
    private Integer updateQuantity;// 更新数量

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
