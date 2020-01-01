package com.arc.core.model.domain.shop;

import com.arc.core.model.BaseModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 购物小票
 *
 * @author 叶超
 * @since 2019/12/30 18:30
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_shopping_receipt")
public class ShoppingReceipt extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id
    private LocalDateTime transactionTime;// 交易时间

    private String shopCode = "9696";// 店铺编码
    private String cashRegisterCode = "TZ02";// 收银机编码
    private String transactionType = "零售销售";// 交易类型

    private Long cashierId;// 收银员编码
    private Long shoppingReceiptId;// 小票编码
    private Long orderId;// 订单号码


    private String name;// 名中文称
    private String nameEnglish;// 英文名称 （备用）

    private String priceUnit = "元";// 价格单位

    private int totalAmount;//总数量
    private int totalFinalPrice;// 成交价
    private int totalDiscount;// 总折扣

    // 应收：receivable、应付：payable、实收：receipts、实付：payment
    private int change;//找零 = 实收 - 应收款
    private int receivable;//应收款
    private int receipts;//实收

    private String payWay;//支付方式

    private String remark;// 备注
    private boolean state;// 状态，暂时规划true=非0/false=0

    private String avatar;// 图片--二维码

    private String consumerHoline;//客户热线

    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    public float getTotalFinalPrice() {
        return (float) ((float) totalFinalPrice / 10000F);
    }
}
