package com.arc.core.model.domain.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品实体
 *
 * @author 叶超
 * @since 2019/12/30 18:30
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_shopping_commodity")
public class ShoppingCommodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id

    private String name;// 名中文称

    private int amount;// 数量
    private String amountUnit;// 数量单位

    private int unitPrice;//单价
    private String priceUnit;// 价格单位

    private int finalPrice;// 成交价 就是该项商品实际需要支付金额



    private boolean state;// 状态，暂时规划true=非0/false=0
    private String remark;// 备注
    private String avatar;// 图

    //private String code;// 编码（备用）
    private String nameEnglish;// 英文名称 （备用）
    private int discount;// 折扣率（备用）
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
}
