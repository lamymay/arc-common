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
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 交易时间
     */
    private LocalDateTime transactionTime;


    private int state;//状态(0=下线/10=正在进行/20=?/30=?/.../99=终态已完成)

    private Long sellerId;//销售方
    private Long buyerId;//买方
    private Long cashierId;//收银方

    private Integer totalAmount;//总数量
    private Integer totalFinalPrice;// 成交价
    private Integer totalDiscount;// 总折扣


    private int orderType;//订单类型

    private String orderNumber;//订单号 字符类型
    private Long shoppingReceiptId;// 小票编码

    private String shopCode = "9696";// 店铺编码
    private String cashRegisterCode = "TZ02";// 收银机编码
    private String transactionType = "零售销售";// 交易类型

    private String name;// 名中文称
    private String nameEnglish;// 英文名称 （备用）
    private String priceUnit = "元";// 货币单位


    // 应收：receivable、应付：payable、实收：receipts、实付：payment
    private Integer change;//找零 = 实收 - 应收款
    private Integer receivable;//应收款
    private Integer receipts;//实收

    private String payWay;//支付方式

    private String remark;// 备注
    private String avatar;// 图片--二维码

    private String consumerHotline;//客户热线



    /**
     * 用户地址
     */
    private Long userAddressId;




    private List<Long> skuIds;//奖品/货物/东西的ids

    private Long playTotalTime;//捐成功了几次


    /**
     * 扩展字段json
     */
    private Map<String, Object> extend;

}
