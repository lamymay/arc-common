package com.arc.core.model.domain.shop;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 订单表相对应的实体
 *
 * @author lamy
 * @since 2020/01/25
 */
@Getter
@Setter
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 自增主键ID
     */
    private Long id;
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private Integer orderType;

    private int status;// 状态(0=下线/10=正在进行/20=?/30=?/.../99=终态已完成)
    private String orderNumber;//订单号 字符类型

    private List<Long> skuIds;//奖品/货物/东西的ids

    private Long totalAmount;
    private Long playTotalTime;//捐成功了几次


    /**
     * user信息
     */
    private Long userId;

    /**
     * 用户地址
     */
    private Long userAddressId;


    /**
     * 扩展字段json
     */
    private Map<String, Object> extend;

}
