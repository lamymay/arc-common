package com.arc.core.model.request.shop;

import com.arc.core.model.request.CommonPageQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 购物小票
 *
 * @author lamy
 * @since 2019-12-30 22:24:13
 */
@Getter
@Setter
public class ShoppingReceiptRequest  extends CommonPageQuery {

	private static final long serialVersionUID = 1L;

	private Long id;// PK
	private String name;// name
	private String shopCode;// 店铺编码
	private String cashRegisterCode;// 收银机编码
	private String transactionType;// 交易类型
	private Integer cashierId;// 收银员编码
	private Integer shoppingReceiptId;// 小票编码
	private Integer orderId;// 订单号码
	private String nameEnglish;// 英文名称 （备用）
	private String priceUnit;// priceUnit 价格单位
	private Integer totalAmount;// 总数量
	private Integer totalFinalPrice;// 成交价
	private Integer totalDiscount;// 总折扣
	private Integer change;// 找零 = 实收 - 应收款
	private Integer receivable;// 应收款
	private Integer receipts;// 实收
	private String payWay;// 支付方式
	private String remark;// 备注
	private Object sate;// 状态
	private String avatar;// 图片--二维码
	private String consumerHoline;// 客户热线
	private Date transactionTime;// 交易时间
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
}
